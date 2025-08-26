package com.ecommerce.stock;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @GetMapping("/{productNumber}")
    public int getStock(@PathVariable String productNumber) {
        System.out.println("stock call with product number: {0}" + productNumber);
        return 436;
    }
}
