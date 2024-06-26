package br.com.fiap.techChallenge4.usecases.pedido.dto;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public interface IPedidoUpdateData {
    Optional<Long> client();
    Optional<Long> product();
    Optional<Integer> qtde();
    Optional<LocalDate> orderDate();
    Optional<BigDecimal> totalValue();
}
