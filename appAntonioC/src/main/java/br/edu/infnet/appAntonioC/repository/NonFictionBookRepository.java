package br.edu.infnet.appAntonioC.repository;

import br.edu.infnet.appAntonioC.model.NonFictionBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NonFictionBookRepository extends JpaRepository<NonFictionBook, Long> {
    // Adicione métodos de consulta personalizados, se necessário
    // Exemplo: List<NonFictionBook> findBySubject(String subject);
}
