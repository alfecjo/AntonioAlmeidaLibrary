-- V2__create_book_table.sql
CREATE TABLE books (
                       id SERIAL PRIMARY KEY,
                       isbn VARCHAR(20) NOT NULL,
                       title VARCHAR(255) NOT NULL,
                       price NUMERIC(10,2) NOT NULL,
                       available BOOLEAN NOT NULL,
                       author_id BIGINT REFERENCES authors(id)
);