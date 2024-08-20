package br.edu.infnet.appAntonioC.service;

import br.edu.infnet.appAntonioC.model.Author;
import br.edu.infnet.appAntonioC.repository.AuthorRepository;
import br.edu.infnet.appAntonioC.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appAntonioC.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;
    private List<Book> books = new ArrayList<>();

    // Método para obter todos os livros
    public List<Book> getAllBooks() {
        return books;
    }

    // Método para obter um livro por ISBN
    public Optional<Book> getBookByIsbn(String isbn) {
        return books.stream()
                .filter(book -> book.getIsbn().equalsIgnoreCase(isbn))
                .findFirst();
    }

    // Método para criar um novo livro
    public Book createBook(Book book) {
        Author author = book.getAuthor();
        if (author != null && author.getId() != null) {
            Optional<Author> existingAuthor = authorRepository.findById(author.getId());
    
            if (existingAuthor.isPresent()) {
                author = existingAuthor.get();
            } else {
                throw new EntityNotFoundException("Author with ID " + author.getId() + " not found.");
            }
        } else {
            throw new IllegalArgumentException("Author information is missing or incomplete.");
        }
    
        book.setAuthor(author);
        return bookRepository.save(book);
    }
    


    // Método para atualizar um livro existente
    public Book updateBook(String isbn, Book bookDetails) {
        Optional<Book> existingBook = getBookByIsbn(isbn);
        if (existingBook.isPresent()) {
            Book book = existingBook.get();
            book.setTitle(bookDetails.getTitle());
            book.setPrice(bookDetails.getPrice());
            book.setAvailable(bookDetails.isAvailable());
            book.setAuthor(bookDetails.getAuthor());
            return book;
        } else {
            throw new RuntimeException("Book not found"); // Lançar exceção ou retornar um Optional vazio
        }
    }

    // Método para deletar um livro por ISBN
    public void deleteBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equalsIgnoreCase(isbn));
    }
}
