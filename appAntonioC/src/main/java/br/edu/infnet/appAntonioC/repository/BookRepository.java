package br.edu.infnet.appAntonioC.repository;

import br.edu.infnet.appAntonioC.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Adicione métodos de consulta personalizados, se necessário
    Book findByIsbn(String isbn);
}
