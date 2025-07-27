package contacts;

import book.Book;
import book.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class RestClientApplication implements CommandLineRunner {
    @Autowired
    private RestOperations restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RestClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String serverUrl = "http://localhost:8080/books";
        String isbn1 = "23423";
        String isbn2 = "54353";

        // add book 1
        restTemplate.postForLocation(serverUrl, new Book(isbn1, "john", "book for the life",
                22.23));
        // add book 2
        restTemplate.postForLocation(serverUrl, new Book(isbn2, "harry", "happiness in life",
                43.33));
        // get frank
        Book book1 = restTemplate.getForObject(serverUrl + "/{23423}", Book.class, isbn1);
        System.out.println("----------- get book for life-----------------------");
        System.out.println(book1.getIsbn() + " " + book1.getTitle());
        // get all
        ResponseEntity<List<Book>> allBooks = restTemplate.exchange(serverUrl, HttpMethod.GET,
                null, new ParameterizedTypeReference<>() {
                });
        System.out.println("----------- get all books-----------------------");

        System.out.println(allBooks);

        // delete John
        restTemplate.delete(serverUrl + "/{54353}", isbn2);

        // update frank
        book1.setTitle("updated title for new book");

        restTemplate.put(serverUrl + "/{23423}", book1, isbn1);

        // get all
        allBooks = restTemplate.exchange(serverUrl, HttpMethod.GET,
                null, new ParameterizedTypeReference<>() {
                });
        System.out.println("----------- get all books-----------------------");
        System.out.println(allBooks);
    }


    @Bean
    RestOperations restTemplate() {
        return new RestTemplate();
    }
}
