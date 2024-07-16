package br.com.fiap.techChallenge4.usecases.pedido;


import br.com.fiap.techChallenge4.entities.pedido.exception.PedidoNotFoundException;
import br.com.fiap.techChallenge4.entities.pedido.gateway.PedidoGateway;
import br.com.fiap.techChallenge4.entities.pedido.model.Pedido;
import br.com.fiap.techChallenge4.infraestructure.config.db.schema.StatusSchema;
import br.com.fiap.techChallenge4.infraestructure.pedido.dto.PedidoUpdateData;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class UpdatePedidoUseCase {
    private final PedidoGateway pedidoGateway;

    public UpdatePedidoUseCase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public Pedido execute(Long id, PedidoUpdateData updateData) throws PedidoNotFoundException {
        Pedido pedido = pedidoGateway.findById(id).orElseThrow( PedidoNotFoundException::new);
        updateStatusPresent(pedido::setStatus, updateData::statusSchema );

        return this.pedidoGateway.update( pedido );
    }

    private void updateStatusPresent(Consumer<StatusSchema> setter, Supplier<Optional<StatusSchema>> valueSupplier) {
        valueSupplier.get().ifPresent(setter);
    }
}
