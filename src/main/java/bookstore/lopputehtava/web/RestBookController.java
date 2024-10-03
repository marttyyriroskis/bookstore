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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/books")
public class RestBookController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("")
    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Book> getOneBook(@PathVariable("id") Long bookId) {
        return bookRepository.findById(bookId);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("")
    Book newBook(@RequestBody Book newBook) {
        return bookRepository.save(newBook);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("{id}")
    Book editBook(@RequestBody Book editedBook, @PathVariable Long id) {
        editedBook.setId(id);
        return bookRepository.save(editedBook);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public Iterable<Book> deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return bookRepository.findAll();
    }

}
