package br.com.fiap.techChallenge4.usecases;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductStockResponse {
    private Long id;
    private String productName;
    private BigDecimal price;
    private int width;
    private int height;
    private Long stockId;
    private int quantity;
}
