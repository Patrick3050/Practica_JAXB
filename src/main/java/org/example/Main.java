package org.example;
import jakarta.xml.bind.JAXBException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws JAXBException {
        Scanner t = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("""
                    ============= Menú librería ==============
                    1. Mostrar datos.
                    2. Mostrar solo los títulos de los libros.
                    3. Mostrar los libros por autor
                    4. Agregar nuevo libro al XML
                    5. Salir
                    ==========================================
                    Seleccione una opción:\t""");
            opcion = t.nextInt();

            if      (opcion == 1)  Gestion.muestraInformacionTotalLibreria();
            else if (opcion == 2)  Gestion.muestraTitulosLibros();
            else if (opcion == 3)  Gestion.muestraLibrosPorAutor();
            else if (opcion == 4)  Gestion.agregrarLibroNuevo();
            else if (opcion == 5)  System.out.println("Fin del programa.");
            else System.err.println("Opcion inválida intentalo de nuevo.\n");

        } while (opcion != 5);
    }
}