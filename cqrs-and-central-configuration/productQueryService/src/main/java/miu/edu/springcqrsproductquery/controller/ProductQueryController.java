package miu.edu.springcqrsproductquery.controller;

import miu.edu.springcqrsproductquery.domain.ProductView;

import miu.edu.springcqrsproductquery.repositories.ProductQueryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/query/products")
class ProductQueryController {
    private final ProductQueryRepository productQueryRepository;

    public ProductQueryController(ProductQueryRepository productQueryRepository) {
        this.productQueryRepository = productQueryRepository;
    }

    @GetMapping
    public List<ProductView> getAll() {
        return productQueryRepository.findAll();
    }

    @GetMapping("/{productNumber}")
    public ProductView get(@PathVariable String productNumber) {
        return productQueryRepository.findById(productNumber).orElseThrow();
    }
}