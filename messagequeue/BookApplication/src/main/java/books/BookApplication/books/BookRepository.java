package books.BookApplication.books;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {
    // do db use right now
    private final List<Book> books = new ArrayList<>();

    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

    public Optional<Book> findByIsbn(String isbn) {
        return books.stream().filter(book -> book
                        .getIsbn()
                        .equals(isbn))
                .findFirst();
    }


    public Book save(Book book) {
        books.removeIf(checkBook -> checkBook.getIsbn()
                .equals(book.getIsbn()));
        books.add(book);
        return book;
    }

    public void delete(Book book) {
        books.removeIf(checkBook -> checkBook
                .getIsbn()
                .equals(book.getIsbn()));
    }
}
