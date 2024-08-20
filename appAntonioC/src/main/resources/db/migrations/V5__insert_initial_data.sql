-- Inserir autores
INSERT INTO authors (name, email, nationality) VALUES
                                                   ('J.K. Rowling', 'jk.rowling@example.com', 'British'),
                                                   ('Yuval Noah Harari', 'harari@example.com', 'Israeli'),
                                                   ('George Orwell', 'george.orwell@example.com', 'British'),
                                                   ('Malcolm Gladwell', 'malcolm.gladwell@example.com', 'Canadian'),
                                                   ('Agatha Christie', 'agatha.christie@example.com', 'British'),
                                                   ('Stephen King', 'stephen.king@example.com', 'American'),
                                                   ('Michel Foucault', 'michel.foucault@example.com', 'French'),
                                                   ('Neil Gaiman', 'neil.gaiman@example.com', 'British');

-- Inserir livros na tabela books
INSERT INTO books (isbn, title, price, available, author_id) VALUES
                                                                 ('978-0545582889', 'Harry Potter and the Sorcerer''s Stone', 29.99, TRUE, (SELECT id FROM authors WHERE name = 'J.K. Rowling')),
                                                                 ('978-0451524935', 'Animal Farm', 9.99, TRUE, (SELECT id FROM authors WHERE name = 'George Orwell')),
                                                                 ('978-0062073488', 'Murder on the Orient Express', 14.99, TRUE, (SELECT id FROM authors WHERE name = 'Agatha Christie')),
                                                                 ('978-1501142970', 'It', 19.99, TRUE, (SELECT id FROM authors WHERE name = 'Stephen King')),
                                                                 ('978-0062472106', 'American Gods', 17.99, TRUE, (SELECT id FROM authors WHERE name = 'Neil Gaiman')),
                                                                 ('978-0062316097', 'Sapiens: A Brief History of Humankind', 22.99, TRUE, (SELECT id FROM authors WHERE name = 'Yuval Noah Harari')),
                                                                 ('978-0316010665', 'Blink: The Power of Thinking Without Thinking', 15.99, TRUE, (SELECT id FROM authors WHERE name = 'Malcolm Gladwell')),
                                                                 ('978-0679752554', 'Discipline and Punish', 16.99, TRUE, (SELECT id FROM authors WHERE name = 'Michel Foucault'));

-- Inserir livros de ficção
INSERT INTO fiction_books (book_id, genre, is_series) VALUES
                                                          ((SELECT id FROM books WHERE title = 'Harry Potter and the Sorcerer''s Stone'), 'Fantasy', TRUE),
                                                          ((SELECT id FROM books WHERE title = 'Animal Farm'), 'Political Satire', FALSE),
                                                          ((SELECT id FROM books WHERE title = 'Murder on the Orient Express'), 'Mystery', FALSE),
                                                          ((SELECT id FROM books WHERE title = 'It'), 'Horror', TRUE),
                                                          ((SELECT id FROM books WHERE title = 'American Gods'), 'Fantasy', TRUE);

-- Inserir livros de não-ficção
INSERT INTO non_fiction_books (book_id, subject, reference) VALUES
                                                                ((SELECT id FROM books WHERE title = 'Sapiens: A Brief History of Humankind'), 'History', 10),
                                                                ((SELECT id FROM books WHERE title = 'Blink: The Power of Thinking Without Thinking'), 'Psychology', 5),
                                                                ((SELECT id FROM books WHERE title = 'Discipline and Punish'), 'Philosophy', 12);
