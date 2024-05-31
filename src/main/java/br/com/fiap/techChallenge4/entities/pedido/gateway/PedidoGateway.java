package br.com.fiap.techChallenge4.entities.pedido.gateway;

import br.com.fiap.techChallenge4.entities.pedido.model.Pedido;

import java.util.Optional;

public interface PedidoGateway {
    Pedido create(Pedido pedido);
    Pedido update(Pedido pedido);
    Pedido updateById(Pedido pedido);
    void delete(Long id);
    Optional<Pedido> findById(Long id);
}
