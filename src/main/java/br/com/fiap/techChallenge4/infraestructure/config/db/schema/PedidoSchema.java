package br.com.fiap.techChallenge4.infraestructure.config.db.schema;


import br.com.fiap.techChallenge4.entities.pedido.model.Pedido;
import br.com.fiap.techChallenge4.entities.pedido.model.Produto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Pedido")
@Getter
@Setter
public class PedidoSchema extends AbstractEntitySchema<Long> {


    @Size(min = 1, max = Integer.MAX_VALUE)
    private Long client;

    //@Size(min = 1, max = Integer.MAX_VALUE)
//    @OneToMany
//    @JoinColumn(name = "produto_id")
    @ElementCollection
    private List <Produto> product;

    @Size(min = 1, max = Integer.MAX_VALUE)
    private Integer qtde;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate orderDate;

    @NotNull
    @Positive
    private BigDecimal totalValue;

    @Enumerated(EnumType.STRING)
    private StatusPedidoSchema statusPedido;

    public PedidoSchema() {
        super();
    }
    public PedidoSchema(Pedido pedido) {
        this.setId( pedido.getId());
        this.client = pedido.getClient();
        this.product = pedido.getProduto();
        this.qtde = pedido.getQtde();
        this.orderDate = pedido.getOrderDate();
        this.totalValue = pedido.getTotalValue();
        this.setStatusPedido( pedido.getStatusPedido());

    }
    public Pedido toPedido(){
        Pedido pedido = new Pedido(this.client, this.product, this.qtde, this.orderDate, this.totalValue );
        pedido.setId(this.getId());
        pedido.setStatusPedido(this.getStatusPedido());
        return pedido;
    }
}
