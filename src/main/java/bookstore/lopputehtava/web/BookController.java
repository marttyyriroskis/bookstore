package bookstore.lopputehtava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import bookstore.lopputehtava.domain.Book;
import bookstore.lopputehtava.domain.BookRepository;
import bookstore.lopputehtava.domain.CategoryRepository;
import jakarta.validation.Valid;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping(value = { "/index" })
    public String showMainPage() {
        return "main";
    }

    // Show all books
    @GetMapping("/bookList")
    public String showBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "bookList";
    }

    // Add new book
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/newBook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "newBook";
    }

    // Edit book
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        // public String editBook(@RequestParam(name = "id") Long id, Model model) {
        model.addAttribute("editBook", bookRepository.findById(id));
        model.addAttribute("categories", categoryRepository.findAll());
        return "editBook";
    }

    // Save a new book
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/saveBook")
    public String saveBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("editBook", book);
            model.addAttribute("categories", categoryRepository.findAll());
            return "newBook";
        }
        bookRepository.save(book);
        return "redirect:bookList";
    }

    // Save an edited book
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/saveEditedBook")
    public String saveEditedBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("editBook", book);
            model.addAttribute("categories", categoryRepository.findAll());
            return "editBook";
        }
        bookRepository.save(book);
        return "redirect:/bookList";
    }

    // Delete book
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("delete/{id}")
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        bookRepository.deleteById(id);
        return "redirect:/bookList";
    }

}
