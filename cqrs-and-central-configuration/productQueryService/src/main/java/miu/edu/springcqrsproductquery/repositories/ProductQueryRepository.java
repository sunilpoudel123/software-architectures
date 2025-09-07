package miu.edu.springcqrsproductquery.repositories;

import miu.edu.springcqrsproductquery.domain.ProductView;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductQueryRepository extends MongoRepository<ProductView, String> {
}
