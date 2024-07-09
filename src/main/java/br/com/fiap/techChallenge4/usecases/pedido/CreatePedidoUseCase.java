package br.com.fiap.techChallenge4.usecases.pedido;


import br.com.fiap.techChallenge4.entities.pedido.exception.ClientNotFoundException;
import br.com.fiap.techChallenge4.entities.pedido.exception.ProductNotFoundException;
import br.com.fiap.techChallenge4.entities.pedido.exception.ProductNotFoundStockException;
import br.com.fiap.techChallenge4.entities.pedido.gateway.PedidoGateway;
import br.com.fiap.techChallenge4.entities.pedido.model.Pedido;
import br.com.fiap.techChallenge4.infraestructure.config.db.schema.StatusPedidoSchema;
import br.com.fiap.techChallenge4.infraestructure.pedido.controller.Client;
import br.com.fiap.techChallenge4.infraestructure.pedido.controller.Product;
import br.com.fiap.techChallenge4.usecases.ProductStockResponse;
import br.com.fiap.techChallenge4.usecases.pedido.dto.IPedidoRegistrationData;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        this.client= client;
        this.product = product;
    }

    public Pedido execute(IPedidoRegistrationData registrationData){
        validateClient(registrationData.client());
        validateProduct(registrationData.product(),  registrationData.qtde());
        Pedido pedido =
                new Pedido(registrationData.client(), registrationData.product(), registrationData.qtde(), registrationData.orderDate(), registrationData.totalValue());
           pedido.setStatusPedido( StatusPedidoSchema.AGUARDANDO_PAGAMENTO);
        return pedidoGateway.create( pedido );
    }

    private void validateClient(Long clientId) {
        try {
            this.client.getFindByClient(clientId);
        } catch (FeignException.NotFound e) {
            throw new ClientNotFoundException();
        }
    }

    private void validateProduct(Long productId, int quantity) {
        try {
            product.getFindByProduct(productId);
            ProductStockResponse stockResponse = product.getFindByStock(productId);
            if (stockResponse.getQuantity() < quantity) {
                throw new ProductNotFoundStockException();
            }
        } catch (FeignException.NotFound e) {
            throw new ProductNotFoundException();
        }
    }
}
