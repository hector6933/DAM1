package org.Controlador;

import org.Dao.AutorDAO;
import org.Modelo.Autor;

import java.util.Scanner;

public final class LibroController {

    private static Scanner leer = new Scanner(System.in);

    private LibroController() {
    }

    public static String pedirTitulo(){

        System.out.println("Introduce el título del libro");
        System.out.print("> ");
        return leer.nextLine();

    }

    public static Double pedirPrecio(){

        do {
            System.out.println("Introduce el precio del libro");
            System.out.print("> ");

            try {

                double precio = Double.parseDouble(leer.nextLine());

                if (precio < 0 ) {

                    System.out.println("El precio debe de ser positivo !!!");

                } else {

                    return precio;

                }

            } catch (NumberFormatException e) {

                System.out.println("Introduce un número decimal !!!");

            }

        } while (true);

    }

    public static Integer pedirAutor(){

        do {
            System.out.println("Introduce el id del autor del libro");
            System.out.print("> ");

            try {

                int id = Integer.parseInt(leer.nextLine());

                if (id < 0 ) {

                    System.out.println("El id debe de ser positivo !!!");

                } else {

                    boolean correcto = false;

                    for (Autor e: AutorDAO.verAutores("SELECT a.id FROM autores a")) {

                        if (e.getId() == id) {

                            correcto = true;
                            break;

                        }

                    }

                    if (!correcto) {

                        System.out.println("No hay autores con ese ID !!!");

                    }

                    return id;

                }

            } catch (NumberFormatException e) {

                System.out.println("Introduce un número entero !!!");

            }

        } while (true);

    }

    public static void insertarLibro(){



    }

}
