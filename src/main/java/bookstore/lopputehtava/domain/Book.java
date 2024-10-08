package bookstore.lopputehtava.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 1, max = 100)
    private String title;

    @Size(min = 1, max = 100)
    private String author;

    @Size(min = 13, max = 13)
    private String isbn;

    @NotNull
    private int publicationYear;

    @NotNull
    private double price;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    public Book() {
    }

    public Book(String title, String author, String isbn, int publicationYear, double price, Category category) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.price = price;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        if (this.category != null)
            return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn
                    + ", publicationYear=" + publicationYear + ", price=" + price + ", category=" + this.getCategory()
                    + "]";
        else
            return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn
                    + ", publicationYear=" + publicationYear + ", price=" + price + "]";
    }

}
