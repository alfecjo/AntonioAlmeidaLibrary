package br.edu.infnet.service;

import br.edu.infnet.model.Author;
import br.edu.infnet.model.Book;
import br.edu.infnet.model.FictionBook;
import br.edu.infnet.model.NonFictionBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService {

    private List<Author> authors = new ArrayList<>();
    private List<Book> books = new ArrayList<>();

    public LibraryService() {
        // Criação de autores
        Author jkRowling = new Author("J.K. Rowling", "jk.rowling@example.com", "British");
        Author yuvalHarari = new Author("Yuval Noah Harari", "harari@example.com", "Israeli");

        // Adicionando autores à lista
        authors.add(jkRowling);
        authors.add(yuvalHarari);

        // Criação de livros e associação aos autores
        FictionBook harryPotter = new FictionBook("Harry Potter and the Sorcerer's Stone", "978-0747532699", 39.99f, true, "Fantasy", true, jkRowling);
        NonFictionBook sapiens = new NonFictionBook("Sapiens: A Brief History of Humankind", "978-0099590088", 25.99f, true, "History", 10, yuvalHarari);

        // Adicionando livros à lista
        books.add(harryPotter);
        books.add(sapiens);
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Book> getBooks() {
        return books;
    }
}
