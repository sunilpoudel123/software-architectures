package books.BookApplication.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    public Optional<Book> findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book update(String isbn, Book book) {
        Book existingBook = bookRepository.findByIsbn(isbn).orElseThrow();
        existingBook.setAuthor(book.getAuthor());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setPrice(book.getPrice());
        return bookRepository.save(existingBook);
    }

    public void delete(String isbn) {
        Book book = bookRepository.findByIsbn(isbn).orElseThrow();
        bookRepository.delete(book);
    }
}
