package probatinas;

import com.fasterxml.jackson.core.JsonToken;

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

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        boolean salir = false;
        System.out.println("¡ Bienvenido al Databaseproll 2000 !");
        esperar(1);

        do {
            System.out.println("¿Qué desea hacer?");
            System.out.println("1 - Modificar alumnos");
            System.out.println("2 - Ver alumnos");
            System.out.println("0 - SALIR");

            try {

                int opt = Integer.parseInt(leer.nextLine());

                switch (opt) {

                    case 1:
                        
                        break;
                    case 2:
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
