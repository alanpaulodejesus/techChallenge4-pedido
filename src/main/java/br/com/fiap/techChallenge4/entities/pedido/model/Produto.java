package br.com.fiap.techChallenge4.entities.pedido.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Embeddable
public class Produto {
    private Long id;
    private String name;
    private Integer qtde;
    private BigDecimal price;

    public Produto() {
    }

    public Produto(Long id, String name, Integer qtde, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.qtde = qtde;
        this.price = price;
    }
}
