package br.com.fiap.techChallenge4.usecases.pedido;


import br.com.fiap.techChallenge4.entities.pedido.gateway.PedidoGateway;
import br.com.fiap.techChallenge4.entities.pedido.model.Pedido;
import br.com.fiap.techChallenge4.infraestructure.config.db.schema.StatusPedidoSchema;
import br.com.fiap.techChallenge4.usecases.pedido.dto.IPedidoRegistrationData;

public class CreatePedidoUseCase {

    private final PedidoGateway pedidoGateway;

    public CreatePedidoUseCase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public Pedido execute(IPedidoRegistrationData registrationData){

        Pedido pedido =
                new Pedido(registrationData.client(), registrationData.product(), registrationData.qtde(), registrationData.orderDate(), registrationData.totalValue());
           pedido.setStatusPedido( StatusPedidoSchema.AGUARDANDO_PAGAMENTO);
        return pedidoGateway.create( pedido );
    }
}
