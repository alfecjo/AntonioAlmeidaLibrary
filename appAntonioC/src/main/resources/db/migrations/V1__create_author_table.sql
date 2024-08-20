-- V1__create_author_table.sql
CREATE TABLE authors (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         email VARCHAR(255),
                         nationality VARCHAR(100)
);