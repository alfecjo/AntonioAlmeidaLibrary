package br.edu.infnet.appAntonioC.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("NonFiction")
public class NonFictionBook extends Book {

    private String subject;
    private int referenceNumber;

    public NonFictionBook() {}

    public NonFictionBook(String title, String isbn, float price, boolean available, String subject, int referenceNumber, Author author) {
        super(title, isbn, price, available, author);
        this.subject = subject;
        this.referenceNumber = referenceNumber;
    }

    // Getters e setters
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getReferenceNumber() {
        return referenceNumber; // Alterado de 'reference' para 'referenceNumber'
    }

    public void setReferenceNumber(int referenceNumber) { // Alterado de 'reference' para 'referenceNumber'
        this.referenceNumber = referenceNumber;
    }

    @Override
    public String toString() {
        return String.format("NonFictionBook{%s, subject='%s', referenceNumber=%d}", super.toString(), subject, referenceNumber); // Alterado de 'reference' para 'referenceNumber'
    }
}
