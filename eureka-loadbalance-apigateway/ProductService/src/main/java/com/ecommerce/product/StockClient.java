package com.ecommerce.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "stock-service")
interface StockClient {
    @RequestMapping("/stocks/{productnumber}")
    int getStock(@PathVariable("productnumber") String productnumber);
}


