package br.com.fiap.techChallenge4.entities.pedido.model;

import br.com.fiap.techChallenge4.infraestructure.config.db.schema.PedidoSchema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Embeddable
public class Produto {


    private Long id;
    private String name;

    public Produto() {
    }
    public Produto(Long id, String name) {
        this.id=id;
        this.name=name;
    }
}
