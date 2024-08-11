package br.edu.infnet.model;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name;
    private String email;
    private String nationality;
    
    private List<Book> books;

    public Author(String name, String email, String nationality) {
        this.name = name;
        this.email = email;
        this.nationality = nationality;
        this.books = new ArrayList<>();
    }

    // getters e setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", nationality='" + nationality + '\'' +
                ", books=" + books +
                '}';
    }
}
