package br.com.fiap.techChallenge4.infraestructure.pedido.gateway;

import br.com.fiap.techChallenge4.entities.pedido.gateway.PedidoGateway;
import br.com.fiap.techChallenge4.entities.pedido.model.Pedido;
import br.com.fiap.techChallenge4.infraestructure.config.db.repository.PedidoRepository;
import br.com.fiap.techChallenge4.infraestructure.config.db.schema.PedidoSchema;

import java.util.Optional;

public class PedidoDatabaseGateway implements PedidoGateway {

    private final PedidoRepository pedidoRepository;

    public PedidoDatabaseGateway(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public Pedido create(Pedido pedido) {
        return pedidoRepository.save(new PedidoSchema( pedido )).toPedido();
    }

    @Override
    public Pedido update(Pedido pedido) {
        return pedidoRepository.save(new PedidoSchema( pedido )).toPedido();
    }

    @Override
    public Pedido updateById(Pedido pedido) {
        return pedidoRepository.save(new PedidoSchema( pedido )).toPedido();}

    @Override
    public void delete(Long id) {
        pedidoRepository.deleteById(id);
    }



    @Override
    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id).map( PedidoSchema::toPedido );
    }
}
