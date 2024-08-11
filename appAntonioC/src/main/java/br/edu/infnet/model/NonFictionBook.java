package br.edu.infnet.model;

public class NonFictionBook extends Book {
    private String subject;
    private int references;

    // Construtor
    public NonFictionBook(String title, String isbn, float price, boolean available, String subject, int references, Author author) {
        super(title, isbn, price, available, author);
        this.subject = subject;
        this.references = references;
    }

    // Getters e setters
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getReferences() {
        return references;
    }

    public void setReferences(int references) {
        this.references = references;
    }

    @Override
    public String toString() {
        return String.format("NonFictionBook{%s, subject='%s', references=%d}", super.toString(), subject, references);
    }
}
