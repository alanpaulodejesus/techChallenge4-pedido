package br.com.fiap.techChallenge4.infraestructure.pedido.controller;


import br.com.fiap.techChallenge4.entities.pedido.exception.ClientNotFoundException;
import br.com.fiap.techChallenge4.infraestructure.pedido.dto.PedidoPublicData;
import br.com.fiap.techChallenge4.infraestructure.pedido.dto.PedidoRegistrationData;
import br.com.fiap.techChallenge4.usecases.pedido.CreatePedidoUseCase;
import feign.FeignException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CreatePedidoController {
    private final CreatePedidoUseCase createPedidoUseCase;
    private final Client client;

    public CreatePedidoController(CreatePedidoUseCase createPedidoUseCase, Client client) {
        this.createPedidoUseCase = createPedidoUseCase;
        this.client = client;
    }

    @PostMapping("/pedido")
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoPublicData createPedido(@Valid @RequestBody PedidoRegistrationData pedidoData) {
        try {
            client.getFindByClient( pedidoData.client());
        } catch (FeignException.NotFound e) {
            throw new ClientNotFoundException();
        }
        return new PedidoPublicData( createPedidoUseCase.execute(pedidoData));
    }


    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity <String> handleClientNotFoundException(ClientNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
