package br.com.fiap.techChallenge4.infraestructure.pedido.dto;


import br.com.fiap.techChallenge4.entities.pedido.model.Pedido;
import br.com.fiap.techChallenge4.infraestructure.config.db.schema.StatusEntregaSchema;
import br.com.fiap.techChallenge4.usecases.pedido.dto.IPedidoPublicData;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PedidoPublicData(
        Long id,
        String nameClient,
        String nameProduct,
        Integer qtde,
        LocalDate oderDate,
        BigDecimal totalValue
) implements IPedidoPublicData {
    public PedidoPublicData(Pedido pedido){
        this(
                pedido.getId(),
                pedido.getNameClient(),
                pedido.getNameProduct(),
                pedido.getQtde(),
                pedido.getOrderDate(),
                pedido.getTotalValue());
    }

    @Override
    public LocalDate orderDate() {
        return null;
    }
}
