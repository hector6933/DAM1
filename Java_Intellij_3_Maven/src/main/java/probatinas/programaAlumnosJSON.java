package probatinas;

import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class programaAlumnosJSON {

    public static void esperar(int segundos){

        long mili = (long) segundos * 1000;

        try {

            Thread.sleep(mili);

        } catch (InterruptedException e) {

            System.out.println("Error en el tiempo de espera: " + e);

        }

    }


    public static void mostrarRegistros() {

        ObjectMapper mapper = new ObjectMapper();

        Alumnos alumnosDam = null;

        try {

            alumnosDam = mapper.readValue(new File("src/main/java/probatinas/alumnos.json"), Alumnos.class);

        } catch (IOException e) {

            System.out.println("Error al deserializar de JSON !!!: ");
            e.printStackTrace();

        }

        System.out.println("Alumnos: ");
        alumnosDam.mostrarAlumnos();

    }

    public static void mostrarRegistros(String parametro) {

        ObjectMapper mapper = new ObjectMapper();

        Alumnos alumnosDam = null;

        try {

            alumnosDam = mapper.readValue(new File("src/main/java/probatinas/alumnos.json"), Alumnos.class);

        } catch (IOException e) {

            System.out.println("Error al deserializar de JSON !!!: ");
            e.printStackTrace();

        }

        System.out.println("Alumnos: ");

        if (alumnosDam == null) {

            System.out.println("No hay alumnos en el archivo !!!");
            return;

        }

        for (Alumno e: alumnosDam.buscarAlumnos(parametro)) {

            System.out.println(e);

        }

    }


    public static void verAlumnos(){

        Scanner leer = new Scanner(System.in);
        boolean salir = false;
        do {

            System.out.println("1 - Ver a todos");
            System.out.println("2 - Ver por parámetro");
            System.out.println("0 - SALIR");
            System.out.print("> ");

            try {

                int opt = Integer.parseInt(leer.nextLine());
                switch (opt) {

                    case 1:
                        System.out.println("----------------------------------------");
                        mostrarRegistros();
                        System.out.println("----------------------------------------");
                        break;
                    case 2:
                        System.out.println("Introduce el parámetro de búsqueda ():");

                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        salir = true;
                    default:
                        System.out.println("Opción inválida !!!");
                        break;

                }

            } catch (NumberFormatException e) {

                System.out.println("Introduce un número válido!!!");

            }

        } while (!salir);

        leer.close();


    }

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        boolean salir = false;
        System.out.println("¡ Bienvenido al DatabaseProll 2000 !");
        esperar(1);

        do {
            System.out.println("¿Qué desea hacer?");
            System.out.println("1 - Modificar alumnos");
            System.out.println("2 - Ver alumnos");
            System.out.println("0 - SALIR");
            System.out.print("> ");

            try {

                int opt = Integer.parseInt(leer.nextLine());

                switch (opt) {

                    case 1:

                        break;
                    case 2:
                        verAlumnos();
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        salir = true;
                    default:
                        System.out.println("Opción inválida !!!");
                        break;
                }

            } catch (NumberFormatException e) {

                System.out.println("Introduce un número como opción !");

            }

        } while (!salir);

        leer.close();

    }

}
