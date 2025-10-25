package org.example;

import jakarta.xml.bind.*;

import java.io.File;

public class Gestion {
    public static Libreria lib = new Libreria("Las hojas", "Getafe");

    // Crear el contexto JAXB
    public static JAXBContext contexto;

    static {
        try {
            contexto = JAXBContext.newInstance(Libreria.class);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static void actualizarXML() throws JAXBException {
        lib.getLibros().add(new Libro("Cervantes", "Quijote", "El barco de Vapor", "1234", 20.7, 2001));
        lib.getLibros().add(new Libro("Fernando de Rojas", "La celestina", "Anaya", "2458", 15.7, 1985));

        // Marshalling --> objetos JAVA a XML
        Marshaller m = contexto.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        System.out.println("Actualizando XML...");
        m.marshal(lib, new File("libreria.xml"));
        //m.marshal(lib, System.out);
    }

    public static void muestraInformacionLibreria() throws JAXBException {
        // Unmarshalling XML
        // System.out.println("Leemos el XML...");
        Unmarshaller um = contexto.createUnmarshaller();
        Libreria libreriaGetafe = (Libreria) um.unmarshal(new File("libreria.xml"));
        System.out.println(libreriaGetafe+"\n");
    }

}
