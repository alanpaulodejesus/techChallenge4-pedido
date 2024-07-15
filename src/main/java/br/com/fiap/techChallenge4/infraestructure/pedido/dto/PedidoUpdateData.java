package br.com.fiap.techChallenge4.infraestructure.pedido.dto;


import br.com.fiap.techChallenge4.infraestructure.config.db.schema.StatusPedidoSchema;
import br.com.fiap.techChallenge4.usecases.pedido.dto.IPedidoUpdateData;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public record PedidoUpdateData(
        Optional <StatusPedidoSchema> statusPedidoSchema

) implements IPedidoUpdateData {

}
