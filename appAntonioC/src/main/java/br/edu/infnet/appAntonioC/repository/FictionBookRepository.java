package br.edu.infnet.appAntonioC.repository;

import br.edu.infnet.appAntonioC.model.FictionBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FictionBookRepository extends JpaRepository<FictionBook, Long> {
    // Adicione métodos de consulta personalizados, se necessário
    // Exemplo: List<FictionBook> findByGenre(String genre);
}