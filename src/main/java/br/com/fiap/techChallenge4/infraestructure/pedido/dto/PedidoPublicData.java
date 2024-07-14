package br.com.fiap.techChallenge4.infraestructure.pedido.dto;


import br.com.fiap.techChallenge4.entities.pedido.model.Pedido;
import br.com.fiap.techChallenge4.entities.pedido.model.Produto;
import br.com.fiap.techChallenge4.infraestructure.config.db.schema.StatusPedidoSchema;
import br.com.fiap.techChallenge4.usecases.pedido.dto.IPedidoPublicData;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record PedidoPublicData(
        Long id,
        Long client,
        List <Produto> product,
        //Integer qtde,
        LocalDate oderDate,
        BigDecimal totalValue,
        StatusPedidoSchema statusPedido
) implements IPedidoPublicData {
    public PedidoPublicData(Pedido pedido){
        this(
                (Long) pedido.getId(),
                pedido.getClient(),
                pedido.getProduto(),
                //pedido.getQtde(),
                pedido.getOrderDate(),
                pedido.getTotalValue(),
                pedido.getStatusPedido());
    }

    @Override
    public LocalDate orderDate() {
        return null;
    }
}
