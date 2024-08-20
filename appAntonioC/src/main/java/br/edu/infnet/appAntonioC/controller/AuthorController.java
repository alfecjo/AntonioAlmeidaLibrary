package br.edu.infnet.appAntonioC.controller;

import br.edu.infnet.appAntonioC.model.Author;
import br.edu.infnet.appAntonioC.service.AuthorService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService libraryService) {
        this.authorService = libraryService;
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{name}")
    public Optional<Author> getAuthorByName(@PathVariable String name) {
        return authorService.getAuthorByName(name);
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @PutMapping("/{name}")
    public Author updateAuthor(@PathVariable String name, @RequestBody Author author) {
        return authorService.updateAuthor(name, author);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<?> deleteAuthor(@PathVariable String name) {
        authorService.deleteAuthor(name);
        return ResponseEntity.ok().build();
    }
}
