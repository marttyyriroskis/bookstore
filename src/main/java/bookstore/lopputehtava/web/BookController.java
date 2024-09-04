package bookstore.lopputehtava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bookstore.lopputehtava.domain.BookRepository;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String showMainPage() {
        return "main";
    }

    @GetMapping("/booklist")
    public String showCars(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "bookList";
    }

}
