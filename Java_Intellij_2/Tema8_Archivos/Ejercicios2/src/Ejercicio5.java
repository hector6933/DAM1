import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio5 {

    public static void main(String[] args) {


        File archivo1 = new File("carpeta/Ej5/archivo.txt");

        if (!archivo1.exists()) {

            System.out.println("archivo1 NO existe !!!");
            return;

        }
        // Si el fichero otro.txt NO existe el BufferedWriter lo crea
        try (BufferedReader leer = new BufferedReader(new FileReader(archivo1.toString()));
             BufferedWriter escribir = new BufferedWriter(new FileWriter("carpeta/Ej5/otro.txt")) ) {

            String linea;

            while ( (linea = leer.readLine()) != null) {

                escribir.write(linea + "\n");

            }

        } catch (IOException e) {

            System.out.println("Error en la lectura/escritura del archivo !!!");

        }


    }

}
