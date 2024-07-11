package br.com.fiap.techChallenge4.entities.pedido.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Embeddable
public class Produto {

    @Id
    private Long id;
    private String name;


    public Produto(Long id, String name) {
        this.id=id;
        this.name=name;
    }
}
