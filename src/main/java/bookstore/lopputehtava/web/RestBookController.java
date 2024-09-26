package bookstore.lopputehtava.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import bookstore.lopputehtava.domain.Book;
import bookstore.lopputehtava.domain.BookRepository;
import bookstore.lopputehtava.domain.CategoryRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class RestBookController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/books")
    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> getOneBook(@PathVariable("id") Long bookId) {
        return bookRepository.findById(bookId);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/book")
    Book newBook(@RequestBody Book newBook) {
        return bookRepository.save(newBook);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/book/{id}")
    Book editBook(@RequestBody Book editedBook, @PathVariable Long id) {
        editedBook.setId(id);
        return bookRepository.save(editedBook);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/book/{id}")
    public Iterable<Book> deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return bookRepository.findAll();
    }

}
