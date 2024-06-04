package br.com.fiap.techChallenge4.usecases.pedido.dto;


import java.math.BigDecimal;
import java.time.LocalDate;

public interface IPedidoRegistrationData {
    Long client();
    Long product();
    Integer qtde();
    LocalDate orderDate();
    BigDecimal totalValue();

}
