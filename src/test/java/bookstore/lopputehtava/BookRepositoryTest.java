package bookstore.lopputehtava;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import bookstore.lopputehtava.domain.Book;
import bookstore.lopputehtava.domain.BookRepository;
import bookstore.lopputehtava.domain.CategoryRepository;

@SpringBootTest(classes = LopputehtavaApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void findByIdShouldReturnBook() {
        List<Book> books = bookRepository.findById(1L);
        assertThat(books).isNotNull;
    }
}
