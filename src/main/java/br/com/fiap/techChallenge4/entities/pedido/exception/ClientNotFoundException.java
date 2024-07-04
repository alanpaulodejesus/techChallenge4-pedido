package br.com.fiap.techChallenge4.entities.pedido.exception;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException() {
        super("Cliente not found");
    }

}
