package br.com.fiap.techChallenge4.infraestructure.config.web;

import br.com.fiap.techChallenge4.entities.pedido.gateway.PedidoGateway;
import br.com.fiap.techChallenge4.infraestructure.pedido.gateway.PedidoDatabaseGateway;
import br.com.fiap.techChallenge4.infraestructure.config.db.repository.PedidoRepository;
import br.com.fiap.techChallenge4.usecases.pedido.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MvcConfig {

    @Bean
    public CreatePedidoUseCase createPedidoUseCase(PedidoRepository pedidoRepository) {
        PedidoGateway pedidoGateway = new PedidoDatabaseGateway( pedidoRepository );
        return new CreatePedidoUseCase(pedidoGateway);
    }

    @Bean
    public DeletePedidoUseCase deletePedidoUseCase(PedidoRepository pedidoRepository) {
        PedidoGateway pedidoGateway = new PedidoDatabaseGateway( pedidoRepository );
        return new DeletePedidoUseCase( pedidoGateway );
    }

    @Bean
    public GetPedidoUseCase getPedidoUseCase(PedidoRepository pedidoRepository) {
        PedidoGateway pedidoGateway = new PedidoDatabaseGateway( pedidoRepository );
        return new GetPedidoUseCase( pedidoGateway );
    }

    @Bean
    public UpdatePedidoUseCase updatePedidoUseCase(PedidoRepository pedidoRepository) {
        PedidoGateway pedidoGateway = new PedidoDatabaseGateway( pedidoRepository );
        return new UpdatePedidoUseCase( pedidoGateway );
    }
}
