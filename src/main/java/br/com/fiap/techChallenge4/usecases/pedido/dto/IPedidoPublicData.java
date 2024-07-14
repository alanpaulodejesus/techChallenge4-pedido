package br.com.fiap.techChallenge4.usecases.pedido.dto;

import br.com.fiap.techChallenge4.entities.pedido.model.Produto;
import br.com.fiap.techChallenge4.infraestructure.config.db.schema.StatusPedidoSchema;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface IPedidoPublicData {

    Long id();
    Long client();
    List <Produto> product();
    //Integer qtde();
    LocalDate orderDate();
    BigDecimal totalValue();
    StatusPedidoSchema statusPedido();

}
