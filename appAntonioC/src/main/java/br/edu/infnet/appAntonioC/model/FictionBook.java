package br.edu.infnet.appAntonioC.model;

import jakarta.persistence.Entity;

@Entity
public class FictionBook extends Book {

    private String genre;
    private boolean isSeries;

    // Construtor
    public FictionBook(String title, String isbn, float price, boolean available, String genre, boolean isSeries, Author author) {
        super(title, isbn, price, available, author);
        this.genre = genre;
        this.isSeries = isSeries;
    }

    public FictionBook() {
    }

    // Getters e setters
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isSeries() {
        return isSeries;
    }

    public void setSeries(boolean series) {
        isSeries = series;
    }

    @Override
    public String toString() {
        return String.format(
            "{\n" +
            "  \"title\": \"%s\",\n" +
            "  \"isbn\": \"%s\",\n" +
            "  \"price\": %.2f,\n" +
            "  \"available\": %b,\n" +
            "  \"author\": \"%s\",\n" +
            "  \"genre\": \"%s\",\n" +
            "  \"isSeries\": %b\n" +
            "}",
            getTitle(),
            getIsbn(),
            getPrice(),
            isAvailable(),
            getAuthor().getName(),
            genre,
            isSeries
        );
    }
}
