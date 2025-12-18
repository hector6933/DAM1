import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Ejercicio8 {

    public static void main(String[] args) {

        try {

            List<String> lineas = Files.readAllLines(Paths.get("carpeta/Ej8/Archivo.txt"));

            String[] palabras = lineas.toArray(new String[0]);

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");

        }

    }

}
