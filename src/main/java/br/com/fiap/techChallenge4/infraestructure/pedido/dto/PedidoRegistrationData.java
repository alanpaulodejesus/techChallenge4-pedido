package br.com.fiap.techChallenge4.infraestructure.pedido.dto;


import br.com.fiap.techChallenge4.usecases.pedido.dto.IPedidoRegistrationData;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record PedidoRegistrationData(
          Long client,
          List <Long> product,
          Integer qtde,
          LocalDate orderDate
) implements IPedidoRegistrationData {
}
