package miu.edu.springcqrsstock.repositories;

import miu.edu.springcqrsstock.domain.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockRepository extends MongoRepository<Stock, String> {

}