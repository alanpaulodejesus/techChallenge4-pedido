package br.com.fiap.techChallenge4.infraestructure.pedido.dto;


import br.com.fiap.techChallenge4.entities.pedido.model.Produto;
import br.com.fiap.techChallenge4.infraestructure.config.db.schema.StatusSchema;
import br.com.fiap.techChallenge4.usecases.pedido.dto.IPedidoUpdateData;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public record PedidoUpdateData(
        Optional<Long> client,
        Optional <List <Produto>> product,
        Optional<Integer> qtde,
        Optional<LocalDate> orderDate,
        Optional<BigDecimal> totalValue,
        Optional<StatusSchema> status

) implements IPedidoUpdateData {

}
