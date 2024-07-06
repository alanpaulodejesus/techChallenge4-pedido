package br.com.fiap.techChallenge4.entities.pedido.exception;

public class ProductNotFoundStockException extends RuntimeException {

    public ProductNotFoundStockException() {
        super("Product not found stock");
    }
}
