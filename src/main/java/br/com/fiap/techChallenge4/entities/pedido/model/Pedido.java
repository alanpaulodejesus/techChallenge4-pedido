package br.com.fiap.techChallenge4.entities.pedido.model;


import br.com.fiap.techChallenge4.entities.AbstractEntity;
import br.com.fiap.techChallenge4.infraestructure.config.db.schema.StatusSchema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class Pedido extends AbstractEntity<Long> {

    private Long client;

    private List <Produto> produto = new ArrayList <>();

    private Integer qtde;
    private LocalDate orderDate;

    private BigDecimal totalValue;

    private StatusSchema status;

    public Pedido(Long client, List <Produto> produto, Integer qtde, LocalDate orderDate, BigDecimal totalValue, StatusSchema status) {
        this.client = client;
        this.produto = produto;
        this.qtde = qtde;
        this.orderDate = orderDate;
        this.totalValue = totalValue;
        this.status = status;
    }
    public Pedido(){

    }

}
