import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio21 {

    public static void main(String[] args) {

        try (BufferedReader leerBufer = new BufferedReader(new FileReader("carpeta/Ej21/archivo.txt"));
             BufferedWriter writeBufer = new BufferedWriter(new FileWriter("carpeta/Ej21/archivo2.txt"))){

            String linea;

            while ((linea = leerBufer.readLine()) != null) {

                linea = linea.replaceAll("[aAeEiIoOuU]","*");
                writeBufer.write(linea + "\n");

            }

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");

        }

    }

}
