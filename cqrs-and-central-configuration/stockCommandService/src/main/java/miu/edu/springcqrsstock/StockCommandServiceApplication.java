package miu.edu.springcqrsstock;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockCommandServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StockCommandServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {

    }

}
