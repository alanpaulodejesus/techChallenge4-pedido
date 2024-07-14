package br.com.fiap.techChallenge4.usecases.pedido;


import br.com.fiap.techChallenge4.entities.pedido.exception.ClientNotFoundException;
import br.com.fiap.techChallenge4.entities.pedido.exception.ProductNotFoundException;
import br.com.fiap.techChallenge4.entities.pedido.exception.ProductNotFoundStockException;
import br.com.fiap.techChallenge4.entities.pedido.gateway.PedidoGateway;
import br.com.fiap.techChallenge4.entities.pedido.model.Pedido;
import br.com.fiap.techChallenge4.entities.pedido.model.Produto;
import br.com.fiap.techChallenge4.infraestructure.config.db.schema.StatusPedidoSchema;
import br.com.fiap.techChallenge4.infraestructure.pedido.controller.Client;
import br.com.fiap.techChallenge4.infraestructure.pedido.controller.Product;
import br.com.fiap.techChallenge4.usecases.ProductStockResponse;
import br.com.fiap.techChallenge4.usecases.pedido.dto.IPedidoRegistrationData;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CreatePedidoUseCase {

    private final PedidoGateway pedidoGateway;
    @Autowired
    private Client client;
    @Autowired
    private Product product;

    public CreatePedidoUseCase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public CreatePedidoUseCase(PedidoGateway pedidoGateway, Client client, Product product) {
        this.pedidoGateway = pedidoGateway;
        this.client = client;
        this.product = product;
    }

    public Pedido execute(IPedidoRegistrationData registrationData) {
        List<Produto> produtoList = new ArrayList<>();
        validateClient(registrationData.client());
        produtoList = validateProduct(produtoList, registrationData.product(), registrationData.qtde());
        BigDecimal totalValue = calculateTotalValue(produtoList);
        Pedido pedido = new Pedido(registrationData.client(), produtoList, registrationData.orderDate(), totalValue);
        pedido.setStatusPedido(StatusPedidoSchema.AGUARDANDO_PAGAMENTO);
        return pedidoGateway.create(pedido);
    }

    private void validateClient(Long clientId) {
        try {
            this.client.getFindByClient(clientId);
        } catch (FeignException.NotFound e) {
            throw new ClientNotFoundException();
        }
    }

    private List<Produto> validateProduct(List<Produto> produtoList, List<Long> products, int quantity) {
        for (Long productId : products) {
            try {
                product.getFindByProduct(productId);
                ProductStockResponse stockResponse = product.getFindByStock(productId);
                if (stockResponse.getQuantity() < quantity) {
                    throw new ProductNotFoundStockException();
                }
                ProductStockResponse priceProductStock = product.getFindByProduct( productId);
                BigDecimal valorTotal = priceProductStock.getPrice().multiply(BigDecimal.valueOf(quantity));
                produtoList.add(new Produto(stockResponse.getId(), stockResponse.getProductName(), quantity, valorTotal));
            } catch (FeignException.NotFound e) {
                throw new ProductNotFoundException();
            }
        }
        return produtoList;
    }

    private BigDecimal calculateTotalValue(List<Produto> produtos) {
        BigDecimal totalValue = BigDecimal.ZERO;
        for (Produto produto : produtos) {
            totalValue = totalValue.add(produto.getPrice());
        }
        return totalValue;
    }
}