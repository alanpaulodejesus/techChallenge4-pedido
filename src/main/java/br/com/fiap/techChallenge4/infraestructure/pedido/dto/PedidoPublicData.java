package br.com.fiap.techChallenge4.infraestructure.pedido.dto;


import br.com.fiap.techChallenge4.entities.pedido.model.Pedido;
import br.com.fiap.techChallenge4.infraestructure.config.db.schema.StatusPedidoSchema;
import br.com.fiap.techChallenge4.usecases.pedido.dto.IPedidoPublicData;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PedidoPublicData(
        Long id,
        Long client,
        Long product,
        Integer qtde,
        LocalDate oderDate,
        BigDecimal totalValue,
        StatusPedidoSchema statusPedido
) implements IPedidoPublicData {
    public PedidoPublicData(Pedido pedido){
        this(
                pedido.getId(),
                pedido.getClient(),
                pedido.getProduct(),
                pedido.getQtde(),
                pedido.getOrderDate(),
                pedido.getTotalValue(),
                pedido.getStatusPedido());
    }

    @Override
    public LocalDate orderDate() {
        return null;
    }
}
