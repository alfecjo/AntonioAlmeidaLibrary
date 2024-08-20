package br.edu.infnet.appAntonioC.service;

import br.edu.infnet.appAntonioC.model.Author;
import br.edu.infnet.appAntonioC.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorByName(String name) {
        return authorRepository.findByName(name);
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(String name, Author authorDetails) {
        Optional<Author> existingAuthor = authorRepository.findByName(name);
        if (existingAuthor.isPresent()) {
            Author author = existingAuthor.get();
            author.setName(authorDetails.getName());
            author.setEmail(authorDetails.getEmail());
            author.setNationality(authorDetails.getNationality());
            return authorRepository.save(author);
        } else {
            throw new RuntimeException("Author not found");
        }
    }

    public void deleteAuthor(String name) {
        Optional<Author> author = getAuthorByName(name);
        author.ifPresent(a -> authorRepository.delete(a));
    }
}