package miu.edu.springcqrsproductquery.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Data
@Document(collection = "product_view")
public class ProductView implements Serializable {
    private static final long serialVersionUID = 1L;
    private String productNumber;
    private String name;
    private double price;
    private int numberInStock;

}
