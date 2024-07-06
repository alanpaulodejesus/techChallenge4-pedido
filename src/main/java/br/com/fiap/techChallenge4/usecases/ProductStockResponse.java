package br.com.fiap.techChallenge4.usecases;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductStockResponse {
    private Long id;
    private String name;
    private int price;
    private int width;
    private int height;
    private Long stockId;
    private int quantity;
}
