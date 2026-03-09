package probatinas;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DatabaseProoll2000_JSON {

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

        if (alumnosDam == null) {

            System.out.println("No hay alumnos en el archivo !!!");
            return;

        }

        ArrayList<Alumno> resultado = alumnosDam.buscarAlumnos(parametro);

        if (resultado.isEmpty()) {

            System.out.println("No hay coincidencias con la búsqueda !!!");

        } else {

            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Alumnos: ");
            for (Alumno e: resultado) {

                System.out.println(e);

            }
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

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
                        System.out.println("Introduce un parámetro de búsqueda (Curso,DNI,Nombre,Edad,ID):");
                        String parametro = leer.nextLine();
                        mostrarRegistros(parametro);

                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción inválida !!!");
                        break;

                }

            } catch (NumberFormatException e) {

                System.out.println("Introduce un número válido!!!");

            }

        } while (!salir);

    }

    public static boolean comprobarDni(String input){

        return Pattern.matches("^\\d{8}[A-Z]$",input);

    }

    public static boolean comprobarFecha(String input){

        return Pattern.matches("",input);

    }

    public static void insertarRegistro(){

        Scanner leer = new Scanner(System.in);

        System.out.println("Introduce el nombre: ");
        System.out.print("> ");
        String nombre = leer.nextLine();

        System.out.println("Introduce los apellidos: ");
        System.out.print("> ");
        String apellidos = leer.nextLine();

        do {
            System.out.println("Introduce la edad: ");
            System.out.print("> ");
            try {

                int edad = Integer.parseInt(leer.nextLine());

                if (edad < 0) {

                    System.out.println("La edad debe de ser un número positivo !!!");

                } else {

                    break;

                }

            } catch (NumberFormatException e) {

                System.out.println("La edad debe de ser un número entero !!!");

            }

        } while (true);

        do {

            System.out.println("Introduce el DNI: ");
            System.out.print("> ");
            String dni = leer.nextLine();

            if (!comprobarDni(dni)) {

                System.out.println("Formato dni incorrecto !!! ej: 12345678A");

            } else {

                break;

            }

        } while (true);

        do {

            System.out.println("Introduce la fecha de la matrícula formato dia/mes/año: ");
            System.out.print("> ");
            String fechaMatricula = leer.nextLine();

            if (!comprobarFecha(fechaMatricula)) {

                System.out.println("Formato inválido !!!");

            } else {

                break;

            }

        } while (true);

        System.out.println("Introduce el nombre: ");
        System.out.print("> ");
        String curso = leer.nextLine();

    }

    public static void modificarAlumnos(){

        Scanner leer = new Scanner(System.in);

        System.out.println("1 - Insertar alumnos");
        System.out.println("2 - Eliminar alumnos");
        System.out.println("3 - Modificar alumnos");

        try {

            int opt = Integer.parseInt(leer.nextLine());

            switch (opt) {

                case 1:
                    insertarRegistro();
                    break;
                case 2:
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
                        modificarAlumnos();
                        break;
                    case 2:
                        verAlumnos();
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        salir = true;
                        break;
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
