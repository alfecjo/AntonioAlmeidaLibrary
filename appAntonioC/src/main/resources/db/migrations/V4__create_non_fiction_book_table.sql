-- V4__create_non_fiction_book_table.sql
CREATE TABLE non_fiction_books (
                                   id SERIAL PRIMARY KEY,
                                   subject VARCHAR(255) NOT NULL,
                                   reference INTEGER NOT NULL,
                                   book_id BIGINT REFERENCES books(id)
);
