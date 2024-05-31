package br.com.fiap.techChallenge4.infraestructure.pedido.dto;


import br.com.fiap.techChallenge4.usecases.pedido.dto.IPedidoRegistrationData;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PedidoRegistrationData(
          String nameClient,
          String nameProduct,
          Integer qtde,
          LocalDate orderDate,
          BigDecimal totalValue
) implements IPedidoRegistrationData {
}
