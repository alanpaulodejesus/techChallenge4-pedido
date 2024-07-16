package br.com.fiap.techChallenge4.usecases.pedido;


import br.com.fiap.techChallenge4.entities.pedido.exception.PedidoDeleteNotPermitionException;
import br.com.fiap.techChallenge4.entities.pedido.exception.PedidoNotFoundException;
import br.com.fiap.techChallenge4.entities.pedido.gateway.PedidoGateway;
import br.com.fiap.techChallenge4.entities.pedido.model.Pedido;

public class DeletePedidoUseCase {
    private final PedidoGateway pedidoGateway;

    public DeletePedidoUseCase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }


    public void execute(final Long id) throws PedidoNotFoundException {
        Pedido pedido = pedidoGateway.findById(id)
                .orElseThrow( PedidoNotFoundException::new);

        switch (pedido.getStatus()) {
            case PAGO:
            case AGUARDANDO_ENTREGA:
            case ENTREGUE:
                throw new PedidoDeleteNotPermitionException();
            default:
                pedidoGateway.delete( (Long) pedido.getId());
        }
    }
}
