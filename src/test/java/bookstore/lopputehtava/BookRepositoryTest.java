package bookstore.lopputehtava;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import bookstore.lopputehtava.domain.Book;
import bookstore.lopputehtava.domain.BookRepository;
import bookstore.lopputehtava.domain.Category;
import bookstore.lopputehtava.domain.CategoryRepository;

@SpringBootTest(classes = LopputehtavaApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void findByTitleShouldReturnBook() {
        List<Book> books = bookRepository.findByTitle("title");
        assertThat(books).isNotNull();
    }

    @Test
    public void createNewBook() {
        Category category = new Category("Yaoi fanfiction");
        categoryRepository.save(category);

        Book book = new Book("He did WHAT with WHAT", "Shady McShawty", "ISBN123456789", 2024, 999999.99, category);
        bookRepository.save(book);

        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteNewBook() {
        List<Book> books = bookRepository.findByTitle("title");
        Book book = books.get(0);
        bookRepository.delete(book);
        List<Book> newBooks = bookRepository.findByTitle("title");
        assertThat(newBooks).hasSize(0);
    }

}
