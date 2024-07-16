package br.com.fiap.techChallenge4.infraestructure.pedido.dto;


import br.com.fiap.techChallenge4.infraestructure.config.db.schema.StatusSchema;
import br.com.fiap.techChallenge4.usecases.pedido.dto.IPedidoUpdateData;

import java.util.Optional;

public record PedidoUpdateData(
        Optional <StatusSchema> statusSchema

) implements IPedidoUpdateData {

}
