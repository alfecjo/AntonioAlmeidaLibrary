package br.edu.infnet.appAntonioC.service;

import org.springframework.stereotype.Service;

import br.edu.infnet.appAntonioC.model.NonFictionBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NonFictionBookService {

    private List<NonFictionBook> nonFictionBooks = new ArrayList<>();

    // Método para obter todos os livros de não-ficção
    public List<NonFictionBook> getAllNonFictionBooks() {
        return nonFictionBooks;
    }

    // Método para obter um livro de não-ficção por ISBN
    public Optional<NonFictionBook> getNonFictionBookByIsbn(String isbn) {
        return nonFictionBooks.stream()
                .filter(book -> book.getIsbn().equalsIgnoreCase(isbn))
                .findFirst();
    }

    // Método para criar um novo livro de não-ficção
    public NonFictionBook createNonFictionBook(NonFictionBook nonFictionBook) {
        nonFictionBooks.add(nonFictionBook);
        return nonFictionBook;
    }

    // Método para atualizar um livro de não-ficção existente
    public NonFictionBook updateNonFictionBook(String isbn, NonFictionBook nonFictionBookDetails) {
        Optional<NonFictionBook> existingBook = getNonFictionBookByIsbn(isbn);
        if (existingBook.isPresent()) {
            NonFictionBook book = existingBook.get();
            book.setTitle(nonFictionBookDetails.getTitle());
            book.setPrice(nonFictionBookDetails.getPrice());
            book.setAvailable(nonFictionBookDetails.isAvailable());
            book.setAuthor(nonFictionBookDetails.getAuthor());
            book.setSubject(nonFictionBookDetails.getSubject());
            book.setReference(nonFictionBookDetails.getReference());
            return book;
        } else {
            throw new RuntimeException("NonFiction Book not found"); // Lançar exceção ou retornar um Optional vazio
        }
    }

    // Método para deletar um livro de não-ficção por ISBN
    public void deleteNonFictionBook(String isbn) {
        nonFictionBooks.removeIf(book -> book.getIsbn().equalsIgnoreCase(isbn));
    }
}
