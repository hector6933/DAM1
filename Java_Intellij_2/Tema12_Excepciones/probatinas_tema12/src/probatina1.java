import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public class probatina1 {

    public static void main(String[] args) {

        try (BufferedReader leerBufer = new BufferedReader(new FileReader("carpeta/prob2/archivo.txt"))) {

            String linea;
            while ((linea = leerBufer.readLine()) != null) {

                System.out.println(linea);

            }

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado: " + e.getMessage());

        } catch (IOException e) {

            System.out.println("Error de E/S: " + e.getMessage());

        }

    }

}
