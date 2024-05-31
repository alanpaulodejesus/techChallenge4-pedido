//package br.com.fiap.techChallenge4.infraestructure.pedido.controller;
//
//
//import br.com.fiap.techChallenge4.entities.pedido.exception.PedidoNotFoundException;
//import br.com.fiap.techChallenge4.infraestructure.pedido.dto.PedidoPublicData;
//import br.com.fiap.techChallenge4.usecases.client.GetPedidoByIdentificationUseCase;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//public class GetPedidoByIdentificationController {
//    private final GetPedidoByIdentificationUseCase getPedidoByIdentificationUseCase;
//
//    public GetPedidoByIdentificationController(GetPedidoByIdentificationUseCase getPedidoByIdentificationUseCase) {
//        this.getPedidoByIdentificationUseCase = getPedidoByIdentificationUseCase;
//    }
//
//
//    @GetMapping("/clients/identification/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public PedidoPublicData getClientByName(@PathVariable String id) throws PedidoNotFoundException {
//        return new PedidoPublicData( getPedidoByIdentificationUseCase.execute(id));
//    }
//}
