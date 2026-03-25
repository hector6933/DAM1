package org.Demos;

import org.Controlador.AutorController;
import org.Dao.AutorDAO;
import org.Modelo.Autor;

import org.Modelo.Conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo1 {

    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {

        try (Connection conexion = Conexion.conexionBase()) {

            System.out.println("Conexion exitosa !");

        } catch (SQLException e) {

            System.out.println("Error en la conexión !");
            e.printStackTrace();

        }

        boolean salir = false;
        do {

            System.out.println("Elige: ");
            System.out.println("1 - Insertar");
            System.out.println("2 - Ver");
            System.out.println("3 - Actualizar");
            System.out.println("0 - Salir");
            System.out.print("> ");

            try {
                int opt = Integer.parseInt(leer.nextLine());

                boolean salir2;
                switch (opt) {

                    case 1:

                        do {

                            salir2 = true;
                            System.out.println("1 - Autores");
                            System.out.println("2 - Libros");
                            System.out.print("> ");

                            try {

                                int opt2 = Integer.parseInt(leer.nextLine());

                                switch (opt2) {

                                    case 1:
                                        AutorController.insertarAutores(AutorController.crearAutores());
                                        break;
                                    case 2:
                                        break;
                                    default:
                                        System.out.println("Opción inválida !!!");
                                        salir2 = false;
                                        break;
                                }

                            } catch (NumberFormatException e) {

                                System.out.println("Introduce un número !!!");
                                salir2 = false;

                            }

                        } while (!salir2);

                        break;
                    case 2:

                        do {

                            salir2 = true;
                            System.out.println("1 - Autores");
                            System.out.println("2 - Libros");
                            System.out.println("3 - Autores Y Libros");
                            System.out.print("> ");

                            try {

                                int opt2 = Integer.parseInt(leer.nextLine());

                                switch (opt2) {

                                    case 1:
                                        AutorController.verAutores();
                                        break;
                                    case 3:
                                        AutorController.verAutoresConLibros();
                                        break;
                                    case 2:
                                        break;
                                    default:
                                        System.out.println("Opción inválida !!!");
                                        salir2 = false;
                                        break;
                                }

                            } catch (NumberFormatException e) {

                                System.out.println("Introduce un número !!!");
                                salir2 = false;

                            }

                        } while (!salir2);
                        break;
                    case 3:

                        do {

                            salir2 = true;

                            System.out.println("¿Que quieres actualizar?");
                            System.out.println("1 - Autores");
                            System.out.println("2 - Libros");
                            System.out.print("> ");

                            try {

                                int opt2 = Integer.parseInt(leer.nextLine());

                                switch (opt2) {

                                    case 1:

                                        AutorController.actualizarAutores();

                                        break;
                                    case 3:

                                        break;
                                    case 2:
                                        break;
                                    default:
                                        System.out.println("Opción inválida !!!");
                                        salir2 = false;
                                        break;
                                }

                            } catch (NumberFormatException e) {

                                System.out.println("Introduce un número !!!");
                                salir2 = false;

                            }

                        } while (!salir2);

                        break;
                    case 0:
                        System.out.println("Saliendo");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción inválida !");
                        break;

                }
            } catch (NumberFormatException e) {

                System.out.println("Introduce un número !!!");

            }

        } while (!salir);

        leer.close();

    }

}
