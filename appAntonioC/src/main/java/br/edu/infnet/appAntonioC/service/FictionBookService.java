package br.edu.infnet.appAntonioC.service;

import org.springframework.stereotype.Service;

import br.edu.infnet.appAntonioC.model.FictionBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FictionBookService {

    private List<FictionBook> fictionBooks = new ArrayList<>();

    // Método para obter todos os livros de ficção
    public List<FictionBook> getAllFictionBooks() {
        return fictionBooks;
    }

    // Método para obter um livro de ficção por ISBN
    public Optional<FictionBook> getFictionBookByIsbn(String isbn) {
        return fictionBooks.stream()
                .filter(book -> book.getIsbn().equalsIgnoreCase(isbn))
                .findFirst();
    }

    // Método para criar um novo livro de ficção
    public FictionBook createFictionBook(FictionBook fictionBook) {
        fictionBooks.add(fictionBook);
        return fictionBook;
    }

    // Método para atualizar um livro de ficção existente
    public FictionBook updateFictionBook(String isbn, FictionBook fictionBookDetails) {
        Optional<FictionBook> existingBook = getFictionBookByIsbn(isbn);
        if (existingBook.isPresent()) {
            FictionBook book = existingBook.get();
            book.setTitle(fictionBookDetails.getTitle());
            book.setPrice(fictionBookDetails.getPrice());
            book.setAvailable(fictionBookDetails.isAvailable());
            book.setAuthor(fictionBookDetails.getAuthor());
            book.setGenre(fictionBookDetails.getGenre());
            book.setSeries(fictionBookDetails.isSeries());
            return book;
        } else {
            throw new RuntimeException("Fiction Book not found"); // Lançar exceção ou retornar um Optional vazio
        }
    }

    // Método para deletar um livro de ficção por ISBN
    public void deleteFictionBook(String isbn) {
        fictionBooks.removeIf(book -> book.getIsbn().equalsIgnoreCase(isbn));
    }
}
