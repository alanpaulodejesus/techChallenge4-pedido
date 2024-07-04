package br.com.fiap.techChallenge4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "br.com.fiap.techChallenge4.infraestructure.pedido.controller")
@SpringBootApplication
public class TechChallenge4Application {

	public static void main(String[] args) {
		SpringApplication.run(TechChallenge4Application.class, args);
	}

}
