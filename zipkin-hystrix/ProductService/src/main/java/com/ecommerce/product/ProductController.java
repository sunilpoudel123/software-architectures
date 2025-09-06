package com.ecommerce.product;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
    @HystrixCommand(fallbackMethod = "getProductFallback")
    public ResponseEntity<String> getProduct(@RequestBody Product product) {
        int stockNumber = stockFeignClient.getStock(product.getProductNumber());
        return ResponseEntity.ok("Product exist with {0} stocks " + stockNumber);
    }

    public ResponseEntity<String> getProductFallback(Product product) {
        return ResponseEntity.ok("Fallback: Unable to fetch stock for product " + product.getProductNumber());
    }

}
