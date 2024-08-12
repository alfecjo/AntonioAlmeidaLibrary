package br.edu.infnet.controller;

import br.edu.infnet.model.NonFictionBook;
import br.edu.infnet.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// import java.util.Optional;

@RestController
@RequestMapping("/nonfictionbooks")
public class NonFictionBookController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping
    public List<NonFictionBook> getAllNonFictionBooks() {
        return libraryService.getBooks().stream()
                .filter(book -> book instanceof NonFictionBook)
                .map(book -> (NonFictionBook) book)
                .toList();
    }

    @GetMapping("/{isbn}")
    public NonFictionBook getNonFictionBookByIsbn(@PathVariable String isbn) {
        return (NonFictionBook) libraryService.getBooks().stream()
                .filter(book -> book instanceof NonFictionBook && book.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

//    @PostMapping
//    public void addNonFictionBook(@RequestBody NonFictionBook nonFictionBook) {
//        libraryService.addBook(nonFictionBook);
//    }

//    @PutMapping("/{isbn}")
//    public void updateNonFictionBook(@PathVariable String isbn, @RequestBody NonFictionBook updatedNonFictionBook) {
//        Optional<NonFictionBook> existingBook = libraryService.getBooks().stream()
//                .filter(book -> book instanceof NonFictionBook && book.getIsbn().equals(isbn))
//                .map(book -> (NonFictionBook) book)
//                .findFirst();
//
//        if (existingBook.isPresent()) {
//            NonFictionBook book = existingBook.get();
//            book.setTitle(updatedNonFictionBook.getTitle());
//            book.setPrice(updatedNonFictionBook.getPrice());
//            book.setAvailable(updatedNonFictionBook.isAvailable());
//            book.setSubject(updatedNonFictionBook.getSubject());
//            book.setReferences(updatedNonFictionBook.getReferences());
//            // Update other fields as needed
//        }
//    }

//    @DeleteMapping("/{isbn}")
//    public void deleteNonFictionBook(@PathVariable String isbn) {
//        libraryService.getBooks().removeIf(book -> book instanceof NonFictionBook && book.getIsbn().equals(isbn));
//    }
}
