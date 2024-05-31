package br.com.fiap.techChallenge4.entities.pedido.model;


import br.com.fiap.techChallenge4.entities.AbstractEntity;
import br.com.fiap.techChallenge4.infraestructure.config.db.schema.StatusEntregaSchema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Getter
@Setter
public class Pedido extends AbstractEntity<Long> {

    private String nameClient;

    private String nameProduct;

    private Integer qtde;
    private LocalDate orderDate;

    private BigDecimal totalValue;

    private StatusEntregaSchema statusEntrega;

    public Pedido(String nameClient, String nameProduct, Integer qtde, LocalDate orderDate,BigDecimal totalValue) {
        this.nameClient = nameClient;
        this.nameProduct = nameProduct;
        this.qtde = qtde;
        this.orderDate = orderDate;
        this.totalValue = totalValue;
    }
    public Pedido(){


    }
    public Pedido(StatusEntregaSchema statusEntrega){
        this.statusEntrega = statusEntrega;
    }
}
