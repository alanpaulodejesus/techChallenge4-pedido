package br.com.fiap.techChallenge4.usecases.pedido.dto;


import br.com.fiap.techChallenge4.infraestructure.config.db.schema.StatusSchema;

import java.util.Optional;

public interface IPedidoUpdateData {

    Optional<StatusSchema> statusSchema();
}
