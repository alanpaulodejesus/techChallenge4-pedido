//package br.com.fiap.techChallenge4.usecases.client;
//
//
//import br.com.fiap.techChallenge4.entities.pedido.exception.PedidoNotFoundException;
//import br.com.fiap.techChallenge4.entities.pedido.gateway.PedidoGateway;
//import br.com.fiap.techChallenge4.entities.pedido.model.Pedido;
//
//public class GetPedidoByIdentificationUseCase {
//    private final PedidoGateway pedidoGateway;
//
//    public GetPedidoByIdentificationUseCase(PedidoGateway pedidoGateway) {
//        this.pedidoGateway = pedidoGateway;
//    }
//
//    public Pedido execute(String id) throws PedidoNotFoundException {
//        return this.pedidoGateway
//                .findById( Long.valueOf( id ) )
//                .orElseThrow( PedidoNotFoundException::new);
//    }
//}
