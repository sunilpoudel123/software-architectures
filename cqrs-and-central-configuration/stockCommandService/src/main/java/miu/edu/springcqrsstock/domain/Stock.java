package miu.edu.springcqrsstock.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "stocks")
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;
    private String productNumber;
    private int quantity;
}