package br.com.fiap.techChallenge4.infraestructure.pedido.controller;


import br.com.fiap.techChallenge4.entities.pedido.exception.PedidoNotFoundException;
import br.com.fiap.techChallenge4.infraestructure.pedido.dto.PedidoPublicData;
import br.com.fiap.techChallenge4.usecases.pedido.GetPedidoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetPedidoController {
    private final GetPedidoUseCase getPedidoUseCase;


    public GetPedidoController(GetPedidoUseCase getPedidoUseCase) {
        this.getPedidoUseCase = getPedidoUseCase;
    }

    @GetMapping("/pedido/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PedidoPublicData getClientByName(@PathVariable Long id) throws PedidoNotFoundException {
        return new PedidoPublicData( getPedidoUseCase.execute(id));
    }
}
