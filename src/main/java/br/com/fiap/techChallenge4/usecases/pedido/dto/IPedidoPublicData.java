package br.com.fiap.techChallenge4.usecases.pedido.dto;

import br.com.fiap.techChallenge4.infraestructure.config.db.schema.StatusPedidoSchema;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface IPedidoPublicData {

    Long id();
    Long client();
    Long product();
    Integer qtde();
    LocalDate orderDate();
    BigDecimal totalValue();
    StatusPedidoSchema statusPedido();

}
