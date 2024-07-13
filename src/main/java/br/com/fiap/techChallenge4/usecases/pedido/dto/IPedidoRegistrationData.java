package br.com.fiap.techChallenge4.usecases.pedido.dto;


import br.com.fiap.techChallenge4.infraestructure.config.db.schema.StatusSchema;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface IPedidoRegistrationData {
    Long client();
    List <Long> product();
    Integer qtde();
    LocalDate orderDate();
    StatusSchema status();

}
