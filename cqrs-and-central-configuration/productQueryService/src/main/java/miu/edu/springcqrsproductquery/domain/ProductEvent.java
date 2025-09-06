package miu.edu.springcqrsproductquery.domain;

import lombok.Data;

@Data
public class ProductEvent {
    private String productNumber;
    private String name;
    private double price;
    private String type;
}