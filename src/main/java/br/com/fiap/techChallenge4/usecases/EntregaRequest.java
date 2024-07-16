package br.com.fiap.techChallenge4.usecases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class EntregaRequest {
    private Long idPedido;
    private Integer cepEntrega;

}
