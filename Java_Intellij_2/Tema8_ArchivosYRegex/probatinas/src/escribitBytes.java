import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class escribitBytes {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        try (FileOutputStream escribirBytes = new FileOutputStream("carpeta/prob1/archivo3.txt",true)) {

            do {
                System.out.println("Introduce texto (S para salir):");
                System.out.print("> ");
                String texto = leer.nextLine();
                for (int i = 0; i < texto.length(); i++) {

                    escribirBytes.write((int) texto.charAt(i));

                }
                if (texto.equalsIgnoreCase("S")) {

                    System.out.println("Saliendo...");
                    break;

                } else {

                    escribirBytes.write(13);

                }


            } while (true);

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la escritura del archivo !!!");

        }

        leer.close();

    }

}
