package br.com.fiap.techChallenge4.infraestructure.pedido.controller;


import br.com.fiap.techChallenge4.infraestructure.pedido.dto.PedidoPublicData;
import br.com.fiap.techChallenge4.infraestructure.pedido.dto.PedidoRegistrationData;
import br.com.fiap.techChallenge4.usecases.pedido.CreatePedidoUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CreatePedidoController {
    private final CreatePedidoUseCase createPedidoUseCase;

    public CreatePedidoController(CreatePedidoUseCase createPedidoUseCase) {
        this.createPedidoUseCase = createPedidoUseCase;
    }

    @PostMapping("/pedido")
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoPublicData createPedido(@Valid @RequestBody PedidoRegistrationData pedidoData) {
        return new PedidoPublicData( createPedidoUseCase.execute(pedidoData));
    }
}
