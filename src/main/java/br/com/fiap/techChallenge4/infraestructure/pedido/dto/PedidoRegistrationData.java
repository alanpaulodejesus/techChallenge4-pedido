package br.com.fiap.techChallenge4.infraestructure.pedido.dto;


import br.com.fiap.techChallenge4.usecases.pedido.dto.IPedidoRegistrationData;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PedidoRegistrationData(
          Long client,
          Long product,
          Integer qtde,
          LocalDate orderDate,
          BigDecimal totalValue
) implements IPedidoRegistrationData {
}
