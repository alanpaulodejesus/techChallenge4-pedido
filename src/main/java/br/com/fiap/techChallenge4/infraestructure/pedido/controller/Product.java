package br.com.fiap.techChallenge4.infraestructure.pedido.controller;

import br.com.fiap.techChallenge4.usecases.ProductStockResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Product", url = "http://localhost:8081")
public interface Product {

    @GetMapping("/product/{id}")
    String getFindByProduct(@PathVariable("id") Long id);

    @GetMapping("/stock/{productId}")
    ProductStockResponse getFindByStock(@PathVariable("productId") Long id);

}
