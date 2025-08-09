package com.ecommerce.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "stock-service", url = "http://localhost:8900")
interface StockClient {
    @RequestMapping("/stocks/{productnumber}")
    int getStock(@PathVariable("productnumber") String productnumber);
}


