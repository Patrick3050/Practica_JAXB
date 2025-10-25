package org.example;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"autor", "titulo", "editorial", "isbn", "precio", "anio"})
public class Libro {
    private String autor;
    private String titulo;
    private String editorial;
    private String isbn;
    private double precio;
    private int anio;

    public Libro(){}

    public Libro(String autor, String titulo, String editorial, String isbn, double precio, int anio) {
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
        this.isbn = isbn;
        this.precio = precio;
        this.anio = anio;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getAnio() {
        return anio;
    }

    // para renombrar la etiqueta en el XML a "año"
    @XmlElement(name = "año")
    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return String.format("""
                   \tTitulo: %s
                   \tAutor: %s
                   \tEditorial: %s
                   \tISBN: %s
                   \tPrecio: %.2f
                   \tAño: %d""", titulo, autor, editorial, isbn, precio, anio);

    }
}
