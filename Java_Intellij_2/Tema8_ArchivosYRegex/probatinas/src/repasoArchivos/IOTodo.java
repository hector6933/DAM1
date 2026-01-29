package repasoArchivos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class IOTodo {
    static Scanner leer = new Scanner(System.in);

    public static void escribirBytes(Path ruta) {

        do {
            try (FileOutputStream escribirBytes = new FileOutputStream(ruta.toString(),true)){

                System.out.println("Introduce texto (S - Salir): ");
                System.out.print("> ");
                String input = leer.nextLine();

                if (input.equalsIgnoreCase("s")) {

                    break;

                } else {

                    escribirBytes.write((input + "\n").getBytes());


                }

            } catch (FileNotFoundException e) {

                System.out.println("Archivo NO encontrado !!!");

            } catch (IOException e) {

                System.out.println("Error en la escritura del archivo !!!");

            }

        } while (true);

    }

    public static void leerBytes(Path ruta){

        try (FileInputStream leerBytes = new FileInputStream(ruta.toString())){

            int dataByte;
            System.out.println("Contenido del archivo:");
            while ((dataByte = leerBytes.read()) != -1) {

                System.out.print((char) dataByte);

            }

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error el la lectura del archivo !!!");

        }

    }

    public static Path solicitarRuta(){

        System.out.println("Introduce la ruta del archivo:");
        System.out.print("> ");
        return Path.of(leer.nextLine());

    }

    public static boolean validarOpcionIO(){

        do {
            System.out.println("1 - Leer");
            System.out.println("2 - Escribir");
            try {

                int opt2 = Integer.parseInt(leer.nextLine());
                switch (opt2) {

                    case 1:
                        return true;
                    case 2:
                        return false;
                    default:
                        System.out.println("Opción inválida !!!");
                        break;
                }

            } catch (ArithmeticException e) {

                System.out.println("Opción inválida !!!");

            }
        } while (true);

    }

    public static void main(String[] args) {

        do {
            System.out.println("¿Cómo quieres interactuar con el archivo?");
            System.out.println("1 - Por bytes");
            System.out.println("2 - Por carácteres");
            System.out.println("3 - Por búfer");
            System.out.print("> ");
            try {

                int opt = Integer.parseInt(leer.nextLine());
                switch (opt) {

                    case 1:
                        if (validarOpcionIO()) {

                            leerBytes(solicitarRuta());

                        } else {

                            escribirBytes(solicitarRuta());

                        }
                        break;
                    case 2:
                        if (validarOpcionIO()) {

                            // FUNCION DE LEER POR CARÁCTERES

                        } else {

                            // FUNCIÓN DE ESCRIBIR POR CARÁCTERES

                        }
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Opción inválida !!!");
                        break;
                }
                break;

            } catch (ArithmeticException e) {

                System.out.println("Opción inválida !!!");

            }
        } while (true);


        leer.close();
    }

}
