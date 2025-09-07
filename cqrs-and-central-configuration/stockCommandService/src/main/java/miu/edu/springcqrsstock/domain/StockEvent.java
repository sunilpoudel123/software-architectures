package miu.edu.springcqrsstock.domain;

import lombok.Data;

@Data
public class StockEvent {
    private String productNumber;
    private int quantity;
    private String type;
}
