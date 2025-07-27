package miu.edu.springmongodemo.client;

import miu.edu.springmongodemo.domain.CartItem;
import miu.edu.springmongodemo.domain.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CartClient {

    @Autowired
    private RestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8082/cart";

    public ShoppingCart addItem(String customerId, CartItem item) {
        return restTemplate.postForObject(BASE_URL + "/" + customerId + "/add", item, ShoppingCart.class);
    }

    public ShoppingCart removeItem(String customerId, String productId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(productId, headers);
        return restTemplate.postForObject(BASE_URL + "/" + customerId + "/remove", request, ShoppingCart.class);
    }

    public ShoppingCart viewCart(String customerId) {
        return restTemplate.getForObject(BASE_URL + "/" + customerId, ShoppingCart.class);
    }
}
