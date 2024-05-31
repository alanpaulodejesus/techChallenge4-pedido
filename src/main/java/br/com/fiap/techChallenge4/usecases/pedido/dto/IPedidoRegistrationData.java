package br.com.fiap.techChallenge4.usecases.pedido.dto;


import br.com.fiap.techChallenge4.infraestructure.config.db.schema.StatusEntregaSchema;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface IPedidoRegistrationData {
    String nameClient();

    String nameProduct();

    Integer qtde();
    LocalDate orderDate();

    BigDecimal totalValue();

}
