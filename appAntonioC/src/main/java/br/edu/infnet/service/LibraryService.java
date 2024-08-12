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
        Author georgeOrwell = new Author("George Orwell", "george.orwell@example.com", "British");
        Author malcolmGladwell = new Author("Malcolm Gladwell", "malcolm.gladwell@example.com", "Canadian");
        Author agathaChristie = new Author("Agatha Christie", "agatha.christie@example.com", "British");
        Author stephenKing = new Author("Stephen King", "stephen.king@example.com", "American");
        Author michelFoucault = new Author("Michel Foucault", "michel.foucault@example.com", "French");
        Author neilGaiman = new Author("Neil Gaiman", "neil.gaiman@example.com", "British");

        // Adicionando autores à lista
        authors.add(jkRowling);
        authors.add(yuvalHarari);
        authors.add(georgeOrwell);
        authors.add(malcolmGladwell);
        authors.add(agathaChristie);
        authors.add(stephenKing);
        authors.add(michelFoucault);
        authors.add(neilGaiman);

        // Criação de livros e associação aos autores
        FictionBook harryPotter = new FictionBook("Harry Potter and the Sorcerer's Stone", "978-0747532699", 39.99f, true, "Fantasy", true, jkRowling);
        FictionBook animalFarm = new FictionBook("Animal Farm", "978-0451526342", 12.99f, true, "Political Satire", false, georgeOrwell);
        NonFictionBook sapiens = new NonFictionBook("Sapiens: A Brief History of Humankind", "978-0099590088", 25.99f, true, "History", 10, yuvalHarari);
        NonFictionBook blink = new NonFictionBook("Blink: The Power of Thinking Without Thinking", "978-0316010665", 21.99f, true, "Psychology", 5, malcolmGladwell);
        FictionBook murderOnTheOrientExpress = new FictionBook("Murder on the Orient Express", "978-0062693662", 15.99f, true, "Mystery", false, agathaChristie);
        FictionBook it = new FictionBook("It", "978-1501142970", 19.99f, true, "Horror", true, stephenKing);
        NonFictionBook disciplineAndPunish = new NonFictionBook("Discipline and Punish", "978-0375405820", 29.99f, true, "Philosophy", 12, michelFoucault);
        FictionBook americanGods = new FictionBook("American Gods", "978-0062572235", 18.99f, true, "Fantasy", true, neilGaiman);

        // Adicionando livros à lista
        books.add(harryPotter);
        books.add(animalFarm);
        books.add(sapiens);
        books.add(blink);
        books.add(murderOnTheOrientExpress);
        books.add(it);
        books.add(disciplineAndPunish);
        books.add(americanGods);
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Book> getBooks() {
        return books;
    }
}
