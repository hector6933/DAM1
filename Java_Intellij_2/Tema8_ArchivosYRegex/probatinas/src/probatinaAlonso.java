import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class probatinaAlonso {

    public static void main(String[] args) {

        try (BufferedWriter escribirBufer = new BufferedWriter(new FileWriter("carpeta/alonso/archivo2.txt"))) {

            String texto = Files.readString(Path.of("carpeta/alonso/archivo.txt"));

            escribirBufer.write(Files.readString(Path.of("carpeta/alonso/archivo.txt")).toUpperCase());

            int contador = 0;
            for (int i = 0; i < texto.length(); i++) {

                if (texto.toLowerCase().charAt(i) == 'a') {

                    contador++;

                }

            }

            System.out.println("En este texto hay " + contador + " A");

            escribirBufer.write(Files.readString(Path.of("carpeta/alonso/archivo.txt")).toUpperCase());

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");

        }
    }


}
