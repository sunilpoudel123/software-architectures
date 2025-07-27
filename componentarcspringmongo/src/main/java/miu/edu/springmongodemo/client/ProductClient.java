package miu.edu.springmongodemo.client;

import miu.edu.springmongodemo.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ProductClient {

    @Autowired
    private RestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8082/products";

    public Product getProduct(String id) {
        return restTemplate.getForObject(BASE_URL + "/" + id, Product.class);
    }

    public List<Product> getAllProducts() {
        ResponseEntity<List<Product>> response = restTemplate.exchange(BASE_URL, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Product>>() {});
        return response.getBody();
    }

    public Product createProduct(Product product) {
        return restTemplate.postForObject(BASE_URL, product, Product.class);
    }
}
