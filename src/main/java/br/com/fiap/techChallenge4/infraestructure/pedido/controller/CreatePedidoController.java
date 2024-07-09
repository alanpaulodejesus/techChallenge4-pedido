package br.com.fiap.techChallenge4.infraestructure.pedido.controller;


import br.com.fiap.techChallenge4.entities.pedido.exception.ClientNotFoundException;
import br.com.fiap.techChallenge4.entities.pedido.exception.ProductNotFoundException;
import br.com.fiap.techChallenge4.entities.pedido.exception.ProductNotFoundStockException;
import br.com.fiap.techChallenge4.infraestructure.pedido.dto.PedidoPublicData;
import br.com.fiap.techChallenge4.infraestructure.pedido.dto.PedidoRegistrationData;
import br.com.fiap.techChallenge4.usecases.pedido.CreatePedidoUseCase;
import br.com.fiap.techChallenge4.usecases.ProductStockResponse;
import feign.FeignException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class CreatePedidoController {
    private final CreatePedidoUseCase createPedidoUseCase;
    private final Client client;
    private final Product product;

    public CreatePedidoController(CreatePedidoUseCase createPedidoUseCase, Client client, Product product) {
        this.createPedidoUseCase = createPedidoUseCase;
        this.client = client;
        this.product = product;
    }

    @PostMapping("/pedido")
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoPublicData createPedido(@Valid @RequestBody PedidoRegistrationData pedidoData) {
        return new PedidoPublicData( createPedidoUseCase.execute(pedidoData));
    }
}
