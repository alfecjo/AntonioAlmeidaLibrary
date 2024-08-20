package br.edu.infnet.appAntonioC.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isbn;
    private String title;
    private float price;
    private boolean available;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Author author;

    // Construtores, getters e setters

    public Book(String title, String isbn, float price, boolean available, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.price = price;
        this.available = available;
        setAuthor(author); // Garante que o autor seja setado e o livro adicionado à lista de livros do autor
    }

    public Book() {}

    // Getters e setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
        if (!author.getBooks().contains(this)) {
            author.addBook(this);  // Garante que o livro está na lista do autor
        }
    }

    @Override
public String toString() {
    return String.format(
        "{\n" +
        "  \"title\": \"%s\",\n" +
        "  \"isbn\": \"%s\",\n" +
        "  \"price\": %.2f,\n" +
        "  \"available\": %b,\n" +
        "  \"author\": \"%s\"\n" +
        "}",
        title,
        isbn,
        price,
        available, author != null ? author.getName() : "N/A" // Mostra apenas o nome do autor
    );
}

}
