package repasoArchivos;

import java.io.*;
import java.util.Scanner;

public class EscribirBytes {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        do {
            try (FileOutputStream escribirBytes = new FileOutputStream("carpeta/repaso/repaso2.txt",true)){

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

        leer.close();

    }

}
