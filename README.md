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

## Week 5 (18.9.-25.9.)

- Modify pom.xml and application.properties to accommodate REST API
- Add RestBookController with functionalities find all and find by id
- Edit one-to-many relationships to ignore JSON link
- Add new book and edit book functionalities to RestBookController

## Week 6 (25.9.-2.10.)

- Edit pom.xml to accommodate two new dependencies
- Add WebSecurityConfig.java to make use of authentication, login and logout functionalities
- Add AppUser and AppUserRepository classes to allow for test users
- Add UserDetailServiceImpl.java to authenticate test users
- Edit BookController and RestBookController to make ADD, EDIT, DELETE functionalities unavailable to non-admin users
- Edit bookList.html: logout button, authenticated username, hidden fields for non-admin users

## Week 7 (2.10.-9.10.)

- Edit LopputehtavaApplicationTests to test that BookController starts up normally
- Add WebLayerTest.java that tests that "/index" produces a 200 OK on access
- Add BookRepositoryTest.java to test BookRepository (GET, POST, DELETE)
- Add Dockerfile to start deployment to Render.com
- Deploy project at Render.com
- Add RestBookTest.java to test RESTful Service

## Week 8 (9.10.-16.10.)

- Add bookstore.sql with table creation SQL statements
- Edit application.properties to use PostgreSQL instead of H2
- Add dependency to pom.xml
- Remove test data from main class
- Fix case sensitivity (categoryName in Category.java -> name)
