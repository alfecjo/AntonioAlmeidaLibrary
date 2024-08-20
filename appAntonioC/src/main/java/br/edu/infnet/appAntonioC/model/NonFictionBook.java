package br.edu.infnet.appAntonioC.model;

import jakarta.persistence.Entity;

@Entity
public class NonFictionBook extends Book {

    private String subject;
    private int reference;

    // Construtor
    public NonFictionBook(String title, String isbn, float price, boolean available, String subject, int references, Author author) {
        super(title, isbn, price, available, author);
        this.subject = subject;
        this.reference = references;
    }

    public NonFictionBook() {
    }

    // Getters e setters
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
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
            "  \"subject\": \"%s\",\n" +
            "  \"references\": %d\n" +
            "}",
            getTitle(),
            getIsbn(),
            getPrice(),
            isAvailable(),
            getAuthor().getName(),
            subject,
                reference
        );
    }
}
