package br.edu.infnet.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class Book {
    //id
   private String isbn;
    private String title;


    private float price;
    private boolean available;

    @JsonBackReference
    private Author author;

    public Book(String title, String isbn, float price, boolean available, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.price = price;
        this.available = available;
        this.author = author;
        this.author.addBook(this);  // Adiciona o livro à lista de livros do autor
    }

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
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                ", available=" + available +
                ", author=" + author.getName() +  // Mostra apenas o nome do autor
                '}';
    }
}
