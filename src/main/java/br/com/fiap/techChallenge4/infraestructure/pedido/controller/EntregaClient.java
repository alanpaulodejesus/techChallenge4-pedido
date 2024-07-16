package br.com.fiap.techChallenge4.infraestructure.pedido.controller;

import br.com.fiap.techChallenge4.entities.pedido.model.Pedido;
import br.com.fiap.techChallenge4.usecases.EntregaRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "EntregaClient", url = "http://localhost:8084")
public interface EntregaClient {

    @PostMapping("/entrega")
    String postEntrega(@RequestBody EntregaRequest entregaRequest);

}
