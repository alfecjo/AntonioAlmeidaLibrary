package br.edu.infnet.controller;

import br.edu.infnet.model.Book;
import br.edu.infnet.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/{isbn}")
    public Optional<Book> getBookByIsbn(@PathVariable String isbn) {
        return libraryService.getBooks().stream()
                .filter(book -> isbn.equals(book.getIsbn()))
                .findFirst();
    }
}
