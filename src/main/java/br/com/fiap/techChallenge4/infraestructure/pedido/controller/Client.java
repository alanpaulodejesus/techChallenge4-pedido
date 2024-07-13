package br.com.fiap.techChallenge4.infraestructure.pedido.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Client", url = "http://localhost:8081")
public interface Client {

    @GetMapping("/clients/{id}")
    String getFindByClient(@PathVariable("id") Long id);

}
