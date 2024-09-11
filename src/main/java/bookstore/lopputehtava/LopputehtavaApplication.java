package bookstore.lopputehtava;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.lopputehtava.domain.Book;
import bookstore.lopputehtava.domain.BookRepository;
import bookstore.lopputehtava.domain.Category;
import bookstore.lopputehtava.domain.CategoryRepository;

@SpringBootApplication
public class LopputehtavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LopputehtavaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			Category category1 = new Category("Horror");
			Category category2 = new Category("Fantasy");
			Category category3 = new Category("Drama");

			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);

			bookRepository.save(new Book("title", "author", "isbn", 2010, 10.10, category1));
			bookRepository.save(new Book("title2", "author2", "isbn2", 2011, 20.10, category2));
			bookRepository.save(new Book("title3", "author3", "isbn3", 2012, 30.10, category3));

			for (Book book : bookRepository.findAll()) {
				System.out.println(book.toString());
			}

		};
	}

}
