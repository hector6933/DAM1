package org.Controlador;

import org.Dao.AutorDAO;
import org.Modelo.Autor;

import java.util.ArrayList;
import java.util.Scanner;

public final class AutorController {

    private AutorController() {
    }

    private static Scanner leer = new Scanner(System.in);

    public static Integer pedirIdAutor(){

        do {

            System.out.println("Introduce el ID");
            System.out.print("> ");

            try {

                int id = Integer.parseInt(leer.nextLine());
                return id;

            } catch (NumberFormatException e) {

                System.out.println("Introduce un número entero !!!");

            }

        } while (true);

    }

    public static String pedirNombre(){

        System.out.println("Introduce el nombre:");
        System.out.print("> ");
        return leer.nextLine();

    }

    public static String pedirPais(){

        System.out.println("Introduce el país:");
        System.out.print("> ");
        return leer.nextLine();

    }

    public static ArrayList<Autor> crearAutores(){

        ArrayList<Autor> autores = new ArrayList<>();

        boolean salir;
        do {

            String nombre = pedirNombre();
            String pais = pedirPais();

            autores.add(new Autor(nombre,pais));

            do {

                System.out.println("¿Desea seguir insertando autores? (S/N)");
                System.out.print("> ");
                String opt = leer.nextLine();
                if (opt.equalsIgnoreCase("S")) {

                    salir = false;
                    break;

                } else if (opt.equalsIgnoreCase("N")) {

                    salir = true;
                    break;

                } else {

                    System.out.println("Opción inválida !!!");

                }

            } while (true);


        } while (!salir);
        return autores;

    }

    public static void insertarAutores(ArrayList<Autor> autores){

        for (Autor e: autores) {

            if (!AutorDAO.insertarAutor(e)) {

                System.out.println("Error al insertar el autor " + e.getNombre());

            }

        }

    }

}
