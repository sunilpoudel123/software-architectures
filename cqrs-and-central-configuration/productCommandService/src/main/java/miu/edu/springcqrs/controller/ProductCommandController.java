package miu.edu.springcqrs.controller;

import miu.edu.springcqrs.domain.Product;
import miu.edu.springcqrs.domain.ProductEvent;
import miu.edu.springcqrs.repositories.ProductRepository;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
class ProductCommandController {

    private final ProductRepository productRepository;
    private final JmsTemplate jmsTemplate;

    public ProductCommandController(ProductRepository productRepository, JmsTemplate jmsTemplate) {
        this.productRepository = productRepository;
        this.jmsTemplate = jmsTemplate;
    }

    @PostMapping
    public Product add(@RequestBody Product product) {
        Product saved = productRepository.save(product);
        sendEvent(saved,"CREATED");
        return saved;
    }

    @DeleteMapping("/{productNumber}")
    void delete(@PathVariable String productNumber) {
        productRepository.deleteById(productNumber);
        ProductEvent event = new ProductEvent();
        event.setProductNumber(productNumber);
        event.setType("DELETED");
        jmsTemplate.convertAndSend("product-events", event);
    }

    @PutMapping("/{productNumber}")
    public Product update(@PathVariable String productNumber, @RequestBody Product updated) {
        Product p = productRepository.findById(productNumber).orElseThrow();
        p.setName(updated.getName());
        p.setPrice(updated.getPrice());
        Product saved = productRepository.save(p);
        sendEvent(saved, "UPDATED");
        return saved;
    }

    private void sendEvent(Product product, String type) {
        ProductEvent event = new ProductEvent();
        event.setProductNumber(product.getProductNumber());
        event.setName(product.getName());
        event.setPrice(product.getPrice());
        event.setType(type);
        jmsTemplate.convertAndSend("product-events", event);
    }
}