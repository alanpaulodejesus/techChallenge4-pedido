package br.com.fiap.techChallenge4.entities.pedido.model;


import br.com.fiap.techChallenge4.entities.AbstractEntity;
import br.com.fiap.techChallenge4.infraestructure.config.db.schema.StatusSchema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Pedido extends AbstractEntity{
    private Long client;
    private List<Produto> produto = new ArrayList<>();
    private LocalDate orderDate;
    private BigDecimal totalValue;
    private StatusSchema status;

    public Pedido(Long client, List<Produto> produto, LocalDate orderDate, BigDecimal totalValue) {
        this.client = client;
        this.produto = produto;
        this.orderDate = orderDate;
        this.totalValue = totalValue;
    }

    public Pedido() {
    }
}
