package br.edu.infnet.appAntonioC.controller;

import br.edu.infnet.appAntonioC.model.NonFictionBook;
import br.edu.infnet.appAntonioC.service.NonFictionBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/nonfiction-books")
public class NonFictionBookController {

    @Autowired
    private NonFictionBookService nonFictionBookService;

    // Endpoint para obter todos os livros de não-ficção
    @GetMapping
    public List<NonFictionBook> getAllNonFictionBooks() {
        return nonFictionBookService.getAllNonFictionBooks();
    }

    // Endpoint para obter um livro de não-ficção por ISBN
    @GetMapping("/{isbn}")
    public ResponseEntity<NonFictionBook> getNonFictionBookByIsbn(@PathVariable String isbn) {
        Optional<NonFictionBook> nonFictionBook = nonFictionBookService.getNonFictionBookByIsbn(isbn);
        return nonFictionBook.map(ResponseEntity::ok)
                             .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para criar um novo livro de não-ficção
    @PostMapping
    public ResponseEntity<NonFictionBook> createNonFictionBook(@RequestBody NonFictionBook nonFictionBook) {
        NonFictionBook createdBook = nonFictionBookService.createNonFictionBook(nonFictionBook);
        return ResponseEntity.ok(createdBook);
    }

    // Endpoint para atualizar um livro de não-ficção existente
    @PutMapping("/{isbn}")
    public ResponseEntity<NonFictionBook> updateNonFictionBook(@PathVariable String isbn, @RequestBody NonFictionBook nonFictionBookDetails) {
        NonFictionBook updatedBook = nonFictionBookService.updateNonFictionBook(isbn, nonFictionBookDetails);
        if (updatedBook != null) {
            return ResponseEntity.ok(updatedBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para deletar um livro de não-ficção por ISBN
    @DeleteMapping("/{isbn}")
    public ResponseEntity<?> deleteNonFictionBook(@PathVariable String isbn) {
        Optional<NonFictionBook> nonFictionBook = nonFictionBookService.getNonFictionBookByIsbn(isbn);
        if (nonFictionBook.isPresent()) {
            nonFictionBookService.deleteNonFictionBook(isbn);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
