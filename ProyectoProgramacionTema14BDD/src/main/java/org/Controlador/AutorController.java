package org.Controlador;

import org.Dao.AutorDAO;
import org.Modelo.Autor;
import org.Modelo.Conexion;

import java.sql.Connection;
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

    public static void verAutores(){

        for (Autor e: AutorDAO.verAutores()) {

            System.out.println(e);

        }

    }

    public static void verAutores(String sql){

        for (Autor e: AutorDAO.verAutores(sql)) {

            System.out.println(e);

        }

    }



    public static void verAutoresConLibros(){

        String resultado = AutorDAO.verAutoresConLibros();
        if (resultado == null || resultado.isEmpty()) {

            System.out.println("No hay resultados !");

        } else {

            System.out.println(resultado);

        }

    }

    public static ArrayList<Autor> crearAutores(){

        ArrayList<Autor> autores = new ArrayList<>();

        boolean salir;
        do {

            String nombre = pedirNombre();
            String pais = pedirPais();

            autores.add(new Autor(0,nombre,pais));

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

    public static void actualizarAutores(){

        String campo;

        do {

            System.out.println("¿Qué campo quieres actualizar? (nombre,pais)");
            System.out.print("> ");
            campo = leer.nextLine();

            if ( !campo.equalsIgnoreCase("nombre") && !campo.equalsIgnoreCase("pais")) {

                System.out.println("Campo incorrecto !!!");

            } else {

                break;

            }

        } while (true);

        String condicion;

        boolean salir;
        do {

            salir = false;
            System.out.println("¿Cómo lo quieres actualizar?");
            System.out.println("1 - Por id");
            System.out.println("2 - Por pais");
            System.out.println("3 - Todos");
            System.out.print("> ");

            try {

                int opt = Integer.parseInt(leer.nextLine());

                switch (opt) {

                    case 1:

                        condicion = "id";

                        System.out.println("Introduce el id ");
                        System.out.print("> ");

                        try {

                            int id = Integer.parseInt(leer.nextLine());
                            System.out.println("Introduce el nuevo campo " + campo + " para reemplazar");
                            System.out.print("> ");
                            String reemplazo = leer.nextLine();

                            String sql = "UPDATE autores SET " + campo + " = ? WHERE " + condicion + " = " + id;

                            if (AutorDAO.alterarAutores(reemplazo,sql) == null) {

                                System.out.println("No hay registros para esa condición !!!");

                            }

                            salir = true;

                        } catch (NumberFormatException e) {

                            System.out.println("Introduce un número entero !!!");

                        }

                        break;
                    case 2:

                        condicion = "pais";

                        System.out.println("Introduce el pais ");
                        System.out.print("> ");
                        String pais = leer.nextLine();

                        System.out.println("Introduce nuevo campo " + campo + " para reemplazar");
                        System.out.print("> ");
                        String reemplazo = leer.nextLine();

                        String sql = "UPDATE autores SET " + campo + " = ? WHERE " + condicion + " = ?" ;

                        if (AutorDAO.alterarAutores(pais,reemplazo,sql) == null) {

                            System.out.println("No hay registros para esa condición !!!");

                        }

                        salir = true;

                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Opción inválida !!!");
                        break;

                }

            } catch (NumberFormatException e) {

                System.out.println("Introduce un número !!!");

            }

        } while (!salir);



    }

}
