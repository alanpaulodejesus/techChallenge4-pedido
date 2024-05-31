package br.com.fiap.techChallenge4.usecases.pedido;


import br.com.fiap.techChallenge4.entities.pedido.exception.PedidoNotFoundException;
import br.com.fiap.techChallenge4.entities.pedido.gateway.PedidoGateway;
import br.com.fiap.techChallenge4.entities.pedido.model.Pedido;

public class GetPedidoUseCase {
    private final PedidoGateway pedidoGateway;

    public GetPedidoUseCase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public Pedido execute(Long id) throws PedidoNotFoundException {
        return this.pedidoGateway
                .findById(id)
                .orElseThrow( PedidoNotFoundException::new);
    }
}
