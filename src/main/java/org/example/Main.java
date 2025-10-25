package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class Main {
    public static void main(String[] args) throws JAXBException {
        Libreria lib = new Libreria("Las hojas", "Getafe");
        lib.getLibros().add(new Libro("Cervantes", "Quijote", "El barco de Vapor", "1234"));
        lib.getLibros().add(new Libro("Fernando de Rojas", "La celestina", "Anaya", "2458"));

        // Crear el contexto JAXB
        JAXBContext contexto = JAXBContext.newInstance(Libreria.class);

        // Marshalling --> objetos JAVA a XML
        /*Marshaller m = contexto.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        System.out.println("Generando XML...");
        m.marshal(lib, new File("libreria.xml"));
        m.marshal(lib, System.out);*/

        // Unmarshalling XML
        System.out.println("Leemos el XML...");
        Unmarshaller um = contexto.createUnmarshaller();
        Libreria libreriaGetafe = (Libreria) um.unmarshal(new File("libreria.xml"));
        System.out.println(libreriaGetafe);
    }
}