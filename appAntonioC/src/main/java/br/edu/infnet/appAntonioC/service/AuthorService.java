package br.edu.infnet.appAntonioC.service;

import br.edu.infnet.appAntonioC.model.Author;
import br.edu.infnet.appAntonioC.repository.AuthorRepository;
import br.edu.infnet.appAntonioC.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly = true)
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    @Transactional
    public void addAuthor(String name, String email, String nationality) {
        authorRepository.insertAuthor(name, email, nationality);
    }

    @Transactional
    public void updateAuthor(Long id, String name, String email, String nationality) {
        authorRepository.updateAuthor(id, name, email, nationality);
    }

    @Transactional
    public void deleteAuthor(Long id) {
         bookRepository.deleteBooksByAuthorId(id);
        authorRepository.deleteById(id);
    }
}
