package br.com.fiap.techChallenge4.entities.pedido.model;


import br.com.fiap.techChallenge4.entities.AbstractEntity;
import br.com.fiap.techChallenge4.infraestructure.config.db.schema.StatusPedidoSchema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Getter
@Setter
public class Pedido extends AbstractEntity<Long> {

    private Long client;

    private Long product;

    private Integer qtde;
    private LocalDate orderDate;

    private BigDecimal totalValue;

    private StatusPedidoSchema statusPedido;

    public Pedido(Long client, Long product, Integer qtde, LocalDate orderDate, BigDecimal totalValue) {
        this.client = client;
        this.product = product;
        this.qtde = qtde;
        this.orderDate = orderDate;
        this.totalValue = totalValue;
    }
    public Pedido(){

    }

}
