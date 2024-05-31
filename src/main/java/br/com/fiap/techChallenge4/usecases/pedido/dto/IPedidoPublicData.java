package br.com.fiap.techChallenge4.usecases.pedido.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface IPedidoPublicData {

    Long id();
    String nameClient();
    String nameProduct();
    Integer qtde();
    LocalDate orderDate();
    BigDecimal totalValue();

}
