package br.edu.infnet.appAntonioC.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Fiction")
public class FictionBook extends Book {

    private String genre;
    private Boolean isSeries;

    public FictionBook() {}

    public FictionBook(String title, String isbn, float price, boolean available, String genre, boolean isSeries, Author author) {
        super(title, isbn, price, available, author);
        this.genre = genre;
        this.isSeries = isSeries;
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
        return String.format("FictionBook{%s, genre='%s', isSeries=%b}", super.toString(), genre, isSeries);
    }
}
