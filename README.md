# README

## Week 1 (21.8.-28.8.)

- Course introduction: creating a Springboot project

## Week 2 (28.8.-4.9.)

- Create Bookstore project using Spring Initializr
- Add BookController, which handles GET requests to /index
- Add Book class, which contains attributes title, author, publicationYear, ISBN and price
- Create GitHub repository

## Week 3 (4.9.-11.9.)

- Add JPA and H2 support
- Edit Book class into an entity and add attribute id
- Add crud repository class BookRepository
- Create template bookList.html (endpoint /bookList)
- Add newBook functionality + newBook.html (reroute to /bookList)
- Add delete functionality (reroute to /bookList)
- Add edit functionality + editBook.html (reroute to /bookList)
- Add test Books using the CommandLineRunner
- Add Bootstrap to elements

## Week 4 (11.9.-18.9.)

- Add entity class Category, which contains attributes id and name
- Add one-to-many, many-to-one relationships
- Add crud repository class CategoryRepository
- Add "Category" column to bookList.html
- Add dropdown list to newBook.html and editBook.html
- Add test Categories using the CommandLineRunner
- Edit test Books using the CommandLineRunner
- Add this README
