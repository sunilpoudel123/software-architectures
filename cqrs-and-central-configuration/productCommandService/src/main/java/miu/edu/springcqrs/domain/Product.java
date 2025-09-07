package miu.edu.springcqrs.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "products")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private String productNumber;
    private String name;
    private double price;

}