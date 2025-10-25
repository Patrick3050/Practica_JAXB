package org.example;

import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"autor", "titulo", "editorial", "isbn"})
public class Libro {
    private String autor;
    private String titulo;
    private String editorial;
    private String isbn;

    public Libro() {}

    public Libro(String autor, String titulo, String editorial, String isbn) {
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return String.format("""
                   \tTitulo: %s
                   \tAutor: %s
                   \tEditorial: %s
                   \tISBN: %s""", titulo, autor, editorial, isbn);

    }
}
