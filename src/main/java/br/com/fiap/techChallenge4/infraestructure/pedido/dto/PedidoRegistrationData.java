package br.com.fiap.techChallenge4.infraestructure.pedido.dto;


import br.com.fiap.techChallenge4.usecases.pedido.dto.IPedidoRegistrationData;

import java.time.LocalDate;
import java.util.Map;

public record PedidoRegistrationData(
          Long client,
          Map <Long, Integer> productsQuantityMap,
          LocalDate orderDate
) implements IPedidoRegistrationData {
}
