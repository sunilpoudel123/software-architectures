package miu.edu.springmongodemo.repositories;

import miu.edu.springmongodemo.domain.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartDao extends MongoRepository<ShoppingCart, String> {
}