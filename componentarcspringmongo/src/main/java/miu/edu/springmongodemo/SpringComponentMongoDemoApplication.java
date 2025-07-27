package miu.edu.springmongodemo;

import miu.edu.springmongodemo.client.CartClient;
import miu.edu.springmongodemo.client.ProductClient;
import miu.edu.springmongodemo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringComponentMongoDemoApplication implements CommandLineRunner {

    @Autowired
    private ProductClient productClient;

    @Autowired
    private CartClient cartClient;

    public static void main(String[] args) {
        SpringApplication.run(SpringComponentMongoDemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Product product = new Product();
        product.setName("pen");
        product.setPrice(10);
        product.setDescription("Pilot pen");
        product.setStock(new StockInformation(10, "LOC1"));
        product.setSupplier(new Supplier("SUP1", "XYZ Supplies", "contact1@xyz.com"));

        Product savedProduct = productClient.createProduct(product);
        System.out.println("Created Product: " + savedProduct.getProductId());

        Product fetched = productClient.getProduct(savedProduct.getProductId());
        System.out.println("Fetched Product: " + fetched.getName());

        CartItem item = new CartItem();
        item.setProduct(fetched);
        item.setQuantity(2);

        ShoppingCart cart = cartClient.addItem("customer99", item);
        System.out.println("Cart Total After Add: " + cart.getTotal());

        ShoppingCart viewed = cartClient.viewCart("customer99");
        System.out.println("Viewed Cart Items: " + viewed.getItems().size());
    }

}
