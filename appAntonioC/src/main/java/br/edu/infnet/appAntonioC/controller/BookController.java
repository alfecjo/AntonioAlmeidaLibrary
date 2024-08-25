package br.edu.infnet.appAntonioC.controller;

import br.edu.infnet.appAntonioC.model.Book;
import br.edu.infnet.appAntonioC.service.AuthorService;
import br.edu.infnet.appAntonioC.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService  bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/available")
    public List<Book> getAllAvailableBooks() {
        return bookService.getAllAvailableBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        try {
            Book book = bookService.getBookById(id);
            return ResponseEntity.ok(book);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestParam String type,
                                          @RequestParam String isbn,
                                          @RequestParam String title,
                                          @RequestParam Float price,
                                          @RequestParam Boolean available,
                                          @RequestParam Long authorId,
                                          @RequestParam(required = false) String genre,
                                          @RequestParam(required = false) Boolean isSeries,
                                          @RequestParam(required = false) String subject,
                                          @RequestParam(required = false) Integer referenceNumber) {
        try {
            bookService.addBook(type, title, isbn, price, available, authorId, genre, isSeries, subject, referenceNumber);
            return ResponseEntity.ok("Book added successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id,
                                             @RequestParam String title,
                                             @RequestParam String isbn,
                                             @RequestParam Float price,
                                             @RequestParam Boolean available) {
        try {
            bookService.updateBook(id, title, isbn, price, available);
            return ResponseEntity.ok("Book updated successfully");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
    }

/*
there is no method of deleting a book, as when deleting an Author their corresponding books are deleted.
 */
}
