package br.edu.infnet.controller;

import br.edu.infnet.model.FictionBook;
import br.edu.infnet.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// import java.util.Optional;

@RestController
@RequestMapping("/fictionbooks")
public class FictionBookController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping
    public List<FictionBook> getAllFictionBooks() {
        return libraryService.getBooks().stream()
                .filter(book -> book instanceof FictionBook)
                .map(book -> (FictionBook) book)
                .toList();
    }

//    @GetMapping("/{isbn}")
//    public FictionBook getFictionBookByIsbn(@PathVariable String isbn) {
//        return (FictionBook) libraryService.getBooks().stream()
//                .filter(book -> book instanceof FictionBook && book.getIsbn().equals(isbn))
//                .findFirst()
//                .orElse(null);
//    }

//    @PostMapping
//    public void addFictionBook(@RequestBody FictionBook fictionBook) {
//        libraryService.addBook(fictionBook);
//    }

//    @PutMapping("/{isbn}")
//    public void updateFictionBook(@PathVariable String isbn, @RequestBody FictionBook updatedFictionBook) {
//        Optional<FictionBook> existingBook = libraryService.getBooks().stream()
//                .filter(book -> book instanceof FictionBook && book.getIsbn().equals(isbn))
//                .map(book -> (FictionBook) book)
//                .findFirst();
//
//        if (existingBook.isPresent()) {
//            FictionBook book = existingBook.get();
//            book.setTitle(updatedFictionBook.getTitle());
//            book.setPrice(updatedFictionBook.getPrice());
//            book.setAvailable(updatedFictionBook.isAvailable());
//            book.setGenre(updatedFictionBook.getGenre());
//            book.setSeries(updatedFictionBook.isSeries());
//            // Update other fields as needed
//        }
//    }

//    @DeleteMapping("/{isbn}")
//    public void deleteFictionBook(@PathVariable String isbn) {
//        libraryService.getBooks().removeIf(book -> book instanceof FictionBook && book.getIsbn().equals(isbn));
//    }
}
