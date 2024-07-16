package br.com.fiap.techChallenge4.usecases.pedido;


import br.com.fiap.techChallenge4.entities.pedido.exception.PedidoNotFoundException;
import br.com.fiap.techChallenge4.entities.pedido.gateway.PedidoGateway;
import br.com.fiap.techChallenge4.entities.pedido.model.Pedido;
import br.com.fiap.techChallenge4.infraestructure.config.db.schema.StatusSchema;
import br.com.fiap.techChallenge4.infraestructure.pedido.controller.Client;
import br.com.fiap.techChallenge4.infraestructure.pedido.controller.EntregaClient;
import br.com.fiap.techChallenge4.infraestructure.pedido.controller.Product;
import br.com.fiap.techChallenge4.infraestructure.pedido.dto.PedidoUpdateData;
import br.com.fiap.techChallenge4.usecases.EntregaRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class UpdatePedidoUseCase {
    private final PedidoGateway pedidoGateway;
    @Autowired
    private EntregaClient entrega;
    @Autowired
    private Client client;

    public UpdatePedidoUseCase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public Pedido execute(Long id, PedidoUpdateData updateData) throws PedidoNotFoundException {
        Pedido pedido = pedidoGateway.findById(id).orElseThrow( PedidoNotFoundException::new);
        updateStatusPresent(pedido::setStatus, updateData::statusSchema );

        return this.pedidoGateway.update( pedido );
    }

    public Pedido executePagamento(Long id) throws PedidoNotFoundException {
        Pedido pedido = pedidoGateway.findById(id).orElseThrow( PedidoNotFoundException::new);
        pedido.setStatus(StatusSchema.PAGO);
        var clients = client.getFindByClient( pedido.getClient());
        var cep = (Integer)Integer.parseInt( clients.getAddress().getPostalCode().replace( "-","" ));
        entrega.postEntrega(new EntregaRequest( (Long)pedido.getId(), cep));
        return this.pedidoGateway.update( pedido );
    }

    private void updateStatusPresent(Consumer<StatusSchema> setter, Supplier<Optional<StatusSchema>> valueSupplier) {
        valueSupplier.get().ifPresent(setter);
    }

}
