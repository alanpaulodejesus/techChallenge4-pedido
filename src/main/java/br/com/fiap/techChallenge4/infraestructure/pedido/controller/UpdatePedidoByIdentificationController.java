//package br.com.fiap.techChallenge4.infraestructure.pedido.controller;
//
//
//import br.com.fiap.techChallenge4.entities.pedido.exception.PedidoNotFoundException;
//import br.com.fiap.techChallenge4.infraestructure.pedido.dto.PedidoPublicData;
//import br.com.fiap.techChallenge4.infraestructure.pedido.dto.PedidoUpdateData;
//import br.com.fiap.techChallenge4.usecases.client.UpdatePedidoUseCase;
//import jakarta.validation.Valid;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class UpdatePedidoByIdentificationController {
//    private final UpdatePedidoUseCase updatePedidoUseCase;
//
//    public UpdatePedidoByIdentificationController(UpdatePedidoUseCase updatePedidoUseCase) {
//        this.updatePedidoUseCase = updatePedidoUseCase;
//    }
//
//
//    @PutMapping("/clients/identification/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public PedidoPublicData updateClient(@PathVariable String id, @Valid @RequestBody PedidoUpdateData updateData) throws PedidoNotFoundException {
//        return new PedidoPublicData( updatePedidoUseCase.execute(id,updateData));
//    }
//}
