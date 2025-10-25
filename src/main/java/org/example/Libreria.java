package org.example;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Libreria")
public class Libreria {
    private String nombre;
    private String lugar;
    private List<Libro> libros = new ArrayList<>();

    public Libreria() {}

    public Libreria(String nombre, String lugar) {
        this.nombre = nombre;
        this.lugar = lugar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String listaLibros(List<Libro> libros) {
        StringBuilder datos = new StringBuilder();
        for (int i = 0; i < libros.size();i++) {
            if (i > 0) datos.append("\n\n");
            datos.append(libros.get(i));
        }
        return datos.toString();
    }

    @XmlElementWrapper(name = "Libros")
    @XmlElement(name = "Libro")

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return String.format("""
                        Libreria "%s"
                         Lugar: %s
                         Libros
                        %s""", nombre, lugar, listaLibros(libros));
    }

}
