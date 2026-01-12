import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicio4 {

    public static void main(String[] args) {

        File archivo1 = new File("carpeta/Ej4/archivo.txt");

        if (!archivo1.exists()) {

            System.out.println("El archivo NO existe !!!");
            return;

        }

        System.out.println("Mostrando contenido de Ej4/archivo.txt: ");
        System.out.println("-------------------");

        try (BufferedReader leer = new BufferedReader(new FileReader("carpeta/Ej4/archivo.txt"))) {

            String linea;

            while ((linea = leer.readLine()) != null) {

                System.out.println(linea);

            }

        } catch (Exception e) {

            System.out.println("Error en la lectura del archivo !!!");

        } finally {

            System.out.println("-------------------");
            System.out.println("Terminada la lectura del archivo !");

        }

    }

}
