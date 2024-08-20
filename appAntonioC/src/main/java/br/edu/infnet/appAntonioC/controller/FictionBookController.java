package br.edu.infnet.appAntonioC.controller;

import br.edu.infnet.appAntonioC.model.FictionBook;
import br.edu.infnet.appAntonioC.service.FictionBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fiction-books")
public class FictionBookController {

    @Autowired
    private FictionBookService fictionBookService;

    // Endpoint para obter todos os livros de ficção
    @GetMapping
    public List<FictionBook> getAllFictionBooks() {
        return fictionBookService.getAllFictionBooks();
    }

    // Endpoint para obter um livro de ficção por ISBN
    @GetMapping("/{isbn}")
    public ResponseEntity<FictionBook> getFictionBookByIsbn(@PathVariable String isbn) {
        Optional<FictionBook> fictionBook = fictionBookService.getFictionBookByIsbn(isbn);
        return fictionBook.map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para criar um novo livro de ficção
    @PostMapping
    public ResponseEntity<FictionBook> createFictionBook(@RequestBody FictionBook fictionBook) {
        FictionBook createdBook = fictionBookService.createFictionBook(fictionBook);
        return ResponseEntity.ok(createdBook);
    }

    // Endpoint para atualizar um livro de ficção existente
    @PutMapping("/{isbn}")
    public ResponseEntity<FictionBook> updateFictionBook(@PathVariable String isbn, @RequestBody FictionBook fictionBookDetails) {
        FictionBook updatedBook = fictionBookService.updateFictionBook(isbn, fictionBookDetails);
        if (updatedBook != null) {
            return ResponseEntity.ok(updatedBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para deletar um livro de ficção por ISBN
    @DeleteMapping("/{isbn}")
    public ResponseEntity<?> deleteFictionBook(@PathVariable String isbn) {
        Optional<FictionBook> fictionBook = fictionBookService.getFictionBookByIsbn(isbn);
        if (fictionBook.isPresent()) {
            fictionBookService.deleteFictionBook(isbn);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
