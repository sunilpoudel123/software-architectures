package miu.edu.springmongodemo.service;

import miu.edu.springmongodemo.domain.Product;
import miu.edu.springmongodemo.dto.ProductDto;
import miu.edu.springmongodemo.repositories.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public Product getProductById(String id) {
        return productDao.findById(id)
                .orElse(null);
    }

    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    public Product createProduct(Product product) {
        return productDao.save(product);
    }

    public void updateProduct(Product product) {
        productDao.save(product);
    }

    public void deleteProduct(String id) {
        productDao.deleteById(id);
    }
}
