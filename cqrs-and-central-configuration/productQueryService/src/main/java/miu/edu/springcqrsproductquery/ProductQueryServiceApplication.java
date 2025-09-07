package miu.edu.springcqrsproductquery;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductQueryServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProductQueryServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {

    }
}
