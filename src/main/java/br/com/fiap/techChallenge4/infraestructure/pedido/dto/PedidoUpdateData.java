package br.com.fiap.techChallenge4.infraestructure.pedido.dto;


import br.com.fiap.techChallenge4.usecases.pedido.dto.IPedidoUpdateData;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public record PedidoUpdateData(
        Optional<Long> client,
        Optional<Long> product,
        Optional<Integer> qtde,
        Optional<LocalDate> orderDate,
        Optional<BigDecimal> totalValue

) implements IPedidoUpdateData {

}
