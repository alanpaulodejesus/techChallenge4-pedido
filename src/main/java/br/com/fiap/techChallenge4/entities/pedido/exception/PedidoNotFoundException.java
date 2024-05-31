package br.com.fiap.techChallenge4.entities.pedido.exception;

public class PedidoNotFoundException extends RuntimeException {

    public PedidoNotFoundException() {
        super("Pedido not found");
    }
}
