package miu.edu.springcqrs.repositories;

import miu.edu.springcqrs.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
