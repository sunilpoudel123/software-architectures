package com.ecommerce.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    StockClient stockFeignClient;

    @PostMapping
    public ResponseEntity<String> getProduct(@RequestBody Product product) {
        int stockNumber = stockFeignClient.getStock(product.getProductNumber());
        return ResponseEntity.ok("Product exist with {0} stocks " + stockNumber);
    }
}
