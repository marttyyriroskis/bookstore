package bookstore.lopputehtava;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import bookstore.lopputehtava.web.BookController;

@SpringBootTest
class LopputehtavaApplicationTests {

	@Autowired
	private BookController controller;

	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
