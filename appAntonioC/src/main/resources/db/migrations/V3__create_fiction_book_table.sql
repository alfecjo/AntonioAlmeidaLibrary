-- V3__create_fiction_book_table.sql
CREATE TABLE fiction_books (
                               id SERIAL PRIMARY KEY,
                               genre VARCHAR(255) NOT NULL,
                               is_series BOOLEAN NOT NULL,
                               book_id BIGINT REFERENCES books(id)
);
