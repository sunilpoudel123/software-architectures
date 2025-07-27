package books.BookApplication.books;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final JmsTemplate jmsTemplate;
    private final ObjectMapper objectMapper;

    public BookController(BookService bookService, JmsTemplate jmsTemplate, ObjectMapper objectMapper) {
        this.bookService = bookService;
        this.jmsTemplate = jmsTemplate;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public ResponseEntity<Book> add(@RequestBody Book book) {
        Book savedBook = bookService.save(book);
        sendJmsMessage("ADDED", savedBook);
        return ResponseEntity.ok(savedBook);
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<Book> update(@PathVariable String isbn, @RequestBody Book book) {
        Book updatedBook = bookService.update(isbn, book);
        sendJmsMessage("UPDATED", updatedBook);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<Void> delete(@PathVariable String isbn) {
        Optional<Book> book = bookService.findByIsbn(isbn);
        bookService.delete(isbn);
        sendJmsMessage("DELETED", book.get());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn) {
        Optional<Book> book = bookService.findByIsbn(isbn);
        return book.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping()
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return books.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(books);
    }

    private void sendJmsMessage(String action, Book book) {
        try {
            Map<String, Object> message = new HashMap<>();
            message.put("action", action);
            message.put("book", book);
            String jsonMessage = objectMapper.writeValueAsString(message);
            jmsTemplate.convertAndSend("book.events", jsonMessage);
        } catch (Exception e) {
            System.err.println("Failed to send JMS message: " + e.getMessage());
        }
    }

}
