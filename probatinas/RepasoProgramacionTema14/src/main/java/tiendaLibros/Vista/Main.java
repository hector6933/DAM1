package tiendaLibros.Vista;

import tiendaLibros.Config.Conexion;
import tiendaLibros.Controlador.AutorController;
import tiendaLibros.Modelo.Autor;

import javax.swing.plaf.LabelUI;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner leer = new Scanner(System.in);

    public static void insertarAutores(ArrayList<Autor> autores){

        int cont = 0;
        for (Autor e : autores) {

            try {

                if (!AutorController.insertarAutores(e)) {

                    throw new SQLException();

                }

                cont++;

            } catch (SQLException ex) {

                System.out.println("Error al insertar al autor " + e.getNombre());
                ex.printStackTrace();

            }


        }

        System.out.println("¡ " + cont + " autores insertados !");

    }

    public static ArrayList<Autor> crearAutores() {

        ArrayList<Autor> autores = new ArrayList<>();

        do {

            String nombre;

            do {

                nombre = DataManager.pedirNombre();

                if (!DataManager.comprobarNombreAutor(nombre)) {

                    System.out.println("¡¡¡ Formato de nombre inválido !!!");

                } else {

                    break;

                }

            } while (true);

            String pais;

            do {

                pais = DataManager.pedirPais();

                if (!DataManager.comprobarNombreAutor(pais)) {

                    System.out.println("¡¡¡ Formato de paísz inválido !!!");

                } else {

                    break;

                }

            } while (true);

            autores.add(new Autor(nombre,pais));

        } while (DataManager.continuar("insertando"));

        return autores;

    }

    public static void main(String[] args) {

        try (Connection conexion = Conexion.conexion()) {

            System.out.println("¡ Conexión exitosa con la base de datos !");

        } catch (SQLException e) {

            System.out.println("¡¡¡ Error la conectarse con la base de datos !!!");
            e.printStackTrace();

        }

        do {

            System.out.println("--- ELIGE ---");
            System.out.println("1 - Insertar autor");
            System.out.println("0 - SALIR");
            System.out.print("> ");

            try {

                int opt = Integer.parseInt(leer.nextLine());

                switch (opt) {

                    case 0:
                        System.out.println("Saliendo...");
                        break;
                    case 1:
                        insertarAutores(crearAutores());
                        continue;
                    default:
                        System.out.println("¡¡¡ Opción inválida !!!");
                        continue;

                }

                break;

            } catch (NumberFormatException e) {

                System.out.println("¡¡¡ Introduce un número entero !!!");

            }

        } while (true);

        leer.close();

    }

}
