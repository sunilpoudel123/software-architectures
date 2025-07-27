package miu.edu.springmongodemo.controller;

import miu.edu.springmongodemo.domain.Product;
import miu.edu.springmongodemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product viewProduct(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> listProduct() {
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

}
