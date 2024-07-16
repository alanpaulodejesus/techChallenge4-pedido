package br.com.fiap.techChallenge4.infraestructure.pedido.controller;

import br.com.fiap.techChallenge4.usecases.ClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Client", url = "http://localhost:8080")
public interface Client {

    @GetMapping("/clients/{id}")
    ClientResponse getFindByClient(@PathVariable("id") Long id);

}
