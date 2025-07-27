package miu.edu.springmongodemo.repositories;

import miu.edu.springmongodemo.domain.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CartDao extends MongoRepository<ShoppingCart, String> {
    Optional<ShoppingCart> findByCustomerId(String customerId);
}