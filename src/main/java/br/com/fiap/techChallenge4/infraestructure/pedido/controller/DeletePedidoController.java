package br.com.fiap.techChallenge4.infraestructure.pedido.controller;

import br.com.fiap.techChallenge4.usecases.pedido.DeletePedidoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class DeletePedidoController {
    private final DeletePedidoUseCase deletePedidoUseCase;

    public DeletePedidoController(DeletePedidoUseCase deletePedidoUseCase) {
        this.deletePedidoUseCase = deletePedidoUseCase;
    }

    @DeleteMapping("/pedido/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePedido(@PathVariable Long id) {
        deletePedidoUseCase.execute(id);
    }
}
