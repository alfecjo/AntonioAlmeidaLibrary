package br.edu.infnet.controller;

import br.edu.infnet.model.Author;
import br.edu.infnet.service.LibraryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final LibraryService libraryService;

    public AuthorController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/stephenKing")
    public List<Author> getStephenKing() {
        return libraryService.getAuthors().stream()
                .filter(author -> "Stephen King".equals(author.getName()))
                .collect(Collectors.toList());
    }
}
