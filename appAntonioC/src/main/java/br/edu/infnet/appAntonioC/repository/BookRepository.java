package br.edu.infnet.appAntonioC.repository;

import br.edu.infnet.appAntonioC.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.available = true")
    List<Book> findAllAvailableBooks();

    //insert only existing authorId in the Book table
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO book (isbn, title, price, available, author_id, book_type, genre, is_series, subject, reference_number) " +
            "VALUES (:isbn, :title, :price, :available, :authorId, :bookType, :genre, :isSeries, :subject, :referenceNumber)",
            nativeQuery = true)
    void insertBook(@Param("isbn") String isbn,
                    @Param("title") String title,
                    @Param("price") Float price,
                    @Param("available") Boolean available,
                    @Param("authorId") Long authorId,
                    @Param("bookType") String bookType,
                    @Param("genre") String genre,
                    @Param("isSeries") Boolean isSeries,
                    @Param("subject") String subject,
                    @Param("referenceNumber") Integer referenceNumber);

    @Modifying
    @Transactional
    @Query("DELETE FROM Book b WHERE b.author.id = :authorId")
    void deleteBooksByAuthorId(@Param("authorId") Long authorId);}