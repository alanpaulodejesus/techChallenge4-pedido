package br.com.fiap.techChallenge4.usecases.pedido.dto;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IPedidoRegistrationData {
    Long client();
    Map <Long, Integer> productsQuantityMap();
    LocalDate orderDate();

}
