import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class randomAccesAppend {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        try (RandomAccessFile randomAcces = new RandomAccessFile("carpeta/prob1/archivo3.txt","rw")) {


            do {
                System.out.println("Introduce algo:");
                System.out.print("> ");
                String texto = leer.nextLine();
                randomAcces.seek(randomAcces.length());

                if (texto.equalsIgnoreCase("S")) {

                    System.out.println("Saliendo...");
                    break;

                } else {

                    randomAcces.write((texto + "\n").getBytes());

                }

            } while (true);

            System.out.println("----------------------------------------------");
            System.out.println("Contenido del fichero:");

            randomAcces.seek(0);

            String linea;
            while ((linea = randomAcces.readLine()) != null) {

                System.out.println(linea);

            }

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura o escritura del archivo !!!");

        }

        leer.close();
    }

}
