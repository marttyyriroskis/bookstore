DROP TABLE IF EXISTS AppUser;
DROP TABLE IF EXISTS Book;
DROP TABLE IF EXISTS Category;

CREATE TABLE AppUser (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    passwordHash VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE Category (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE Book (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(100) NOT NULL,
    isbn VARCHAR(13) NOT NULL UNIQUE,
    publicationYear INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    categoryId INT,
    FOREIGN KEY (categoryId) REFERENCES Category(id)
);

INSERT INTO Category (name) VALUES ('Horror');
INSERT INTO Category (name) VALUES ('Fantasy');
INSERT INTO Category (name) VALUES ('Drama');

INSERT INTO Book (title, author, isbn, publicationYear, price, categoryId)
VALUES ('title', 'author', '123456789isbn', 2010, 10.10, 1);

INSERT INTO Book (title, author, isbn, publicationYear, price, categoryId)
VALUES ('title2', 'author2', '123456789isb2', 2011, 20.10, 2);

INSERT INTO Book (title, author, isbn, publicationYear, price, categoryId)
VALUES ('title3', 'author3', '123456789isb3', 2012, 30.10, 3);

INSERT INTO AppUser (username, passwordHash, email, role)
VALUES ('user', '$2a$10$y5tM0lgwY3iCF5VP1swnPObKGmM9LfviKahdlwl0cpK9MfwNIBNaS', 'email1', 'USER');

INSERT INTO AppUser (username, passwordHash, email, role)
VALUES ('admin', '$2a$10$fR9ArgIapYnZo6eg1FnxC.DZPB2VQCi5p6D65Xm8g13bLGfZCRrxS', 'email2', 'ADMIN');

SELECT * FROM AppUser;
SELECT * FROM Book;
SELECT * FROM Category;
