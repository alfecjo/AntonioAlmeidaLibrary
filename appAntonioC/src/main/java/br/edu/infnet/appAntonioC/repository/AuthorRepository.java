package br.edu.infnet.appAntonioC.repository;

import br.edu.infnet.appAntonioC.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO author (name, email, nationality) VALUES (:name, :email, :nationality)", nativeQuery = true)
    void insertAuthor(String name, String email, String nationality);

    @Modifying
    @Transactional
    @Query(value = "UPDATE author SET name = :name, email = :email, nationality = :nationality WHERE id = :id", nativeQuery = true)
    void updateAuthor(Long id, String name, String email, String nationality);
}