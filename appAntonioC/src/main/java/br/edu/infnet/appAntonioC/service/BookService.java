package br.edu.infnet.appAntonioC.service;

import br.edu.infnet.appAntonioC.model.Book;
import br.edu.infnet.appAntonioC.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService( BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllAvailableBooks() {
        return bookRepository.findAllAvailableBooks();
    }

    @Transactional(readOnly = true)
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + id));
    }

    @Transactional
    public void addBook(String type, String title, String isbn, Float price, Boolean available,
                        Long authorId, String genre, Boolean isSeries, String subject, Integer referenceNumber) {
        String bookType = type.toLowerCase();

        if (!"fiction".equalsIgnoreCase(bookType) && !"nonfiction".equalsIgnoreCase(bookType)) {
            throw new IllegalArgumentException("Invalid book type: " + bookType);
        }

        bookRepository.insertBook(isbn, title, price, available, authorId, bookType,
                genre, isSeries, subject, referenceNumber);
    }

    @Transactional
    public void updateBook(Long id, String title, String isbn, Float price, Boolean available) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + id));

        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPrice(price);
        book.setAvailable(available);

        bookRepository.saveAndFlush(book);
    }
}
