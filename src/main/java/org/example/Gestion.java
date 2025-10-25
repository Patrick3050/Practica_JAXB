package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gestion {
    public static Scanner t = new Scanner(System.in);
    public static Libreria lib = new Libreria("Las hojas", "Getafe");

    // Crear el contexto JAXB
    public static JAXBContext contexto;
    public static Unmarshaller um;

    static {
        try {
            contexto = JAXBContext.newInstance(Libreria.class);
            um = contexto.createUnmarshaller();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static void actualizarXML() throws JAXBException {
        // Marshalling --> objetos JAVA a XML
        Marshaller m = contexto.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        System.out.println("Actualizando XML...\n");
        m.marshal(lib, new File("libreria.xml"));
    }

    public static void muestraInformacionTotalLibreria() throws JAXBException {
        // Unmarshalling XML
        Libreria libreriaGetafe = (Libreria) um.unmarshal(new File("libreria.xml"));
        System.out.println(libreriaGetafe+"\n");
    }

    public static void muestraTitulosLibros() throws JAXBException {
        Libreria libreriaGetafe = (Libreria) um.unmarshal(new File("libreria.xml"));
        System.out.println("Títulos de libros:");
        for (int i = 0; i < libreriaGetafe.getLibros().size(); i++) {
            System.out.println(libreriaGetafe.getLibros().get(i).getTitulo());
        }
        System.out.println();
    }

    public static void muestraLibrosPorAutor() throws JAXBException {
        Libreria libreriaGetafe = (Libreria) um.unmarshal(new File("libreria.xml"));
        ArrayList<String> autoresYaMostrados = new ArrayList<>();

        System.out.println("Autores disponibles:");
        for (int i = 0; i < libreriaGetafe.getLibros().size(); i++) {
            String autorActual = libreriaGetafe.getLibros().get(i).getAutor();

            // 3. Comprobar si el autor ya está en la lista de 'autoresYaMostrados'
            // Esto evita imprimir duplicados
            if (!autoresYaMostrados.contains(autorActual)) {

                // 4. Si es la primera vez que lo vemos, no ponemos coma; si no, sí.
                if (i > 0) {
                    System.out.print(", ");
                }

                // 5. Imprimir el autor e inmediatamente agregarlo a la lista de registro
                System.out.print(autorActual);
                autoresYaMostrados.add(autorActual);
            }
        }

        System.out.println("\n\nEscribe el autor disponible:");
        String nombre = t.nextLine();

        System.out.println("Libros del autor: " + nombre);
        for (int i = 0; i < libreriaGetafe.getLibros().size(); i++) {
            if (nombre.equals(libreriaGetafe.getLibros().get(i).getAutor())){
                System.out.println("\tLibro: " + libreriaGetafe.getLibros().get(i).getTitulo());
                System.out.println("\t\teditorial: " + libreriaGetafe.getLibros().get(i).getEditorial());
                System.out.println("\t\tISBN: " + libreriaGetafe.getLibros().get(i).getIsbn());
                System.out.println("\t\tprecio: " + libreriaGetafe.getLibros().get(i).getPrecio());
                System.out.println("\t\taño: " + libreriaGetafe.getLibros().get(i).getAnio());
                System.out.println();
            }
        }
    }

    public static void agregrarLibroNuevo() throws JAXBException {
        lib.getLibros().add(new Libro("Cervantes", "Quijote", "El barco de Vapor", "12131334", 20.7, 2001));
        lib.getLibros().add(new Libro("Fernando de Rojas", "La celestina", "Anaya", "245854412", 15.7, 1985));

        System.out.println("Añadir libro:");
        System.out.println("Titulo:");
        String titulo = t.nextLine();

        System.out.println("Autor:");
        String autor = t.nextLine();

        System.out.println("Editorial:");
        String editorial = t.nextLine();

        System.out.println("ISBN:");
        String isbn = t.nextLine();

        System.out.println("Año:");
        int anio = t.nextInt();
        t.nextLine();

        System.out.println("Precio:");
        double precio  = t.nextDouble();
        t.nextLine();

        lib.getLibros().add(new Libro(autor, titulo, editorial, isbn, precio, anio));

        actualizarXML();
    }

}
