package br.com.fiap.techChallenge4.entities.pedido.exception;

public class PedidoDeleteNotPermitionException extends RuntimeException {

    public PedidoDeleteNotPermitionException() {
        super("Request not allowed to delete");
    }
}
