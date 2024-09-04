package bookstore.lopputehtava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bookstore.lopputehtava.domain.Book;
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

    @GetMapping("/bookList")
    public String showCars(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "bookList";
    }

    @GetMapping("/newBook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "newBook";
    }

    @GetMapping("editBook/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        // public String editBook(@RequestParam(name = "id") Long id, Model model) {
        model.addAttribute("editBook", bookRepository.findById(id));
        return "editBook";
    }

    @PostMapping("/saveBook")
    public String saveCar(@ModelAttribute("book") Book book) {
        bookRepository.save(book);
        return "redirect:bookList";
    }

    @GetMapping("delete/{id}")
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        bookRepository.deleteById(id);
        return "redirect:/bookList";
    }

}
