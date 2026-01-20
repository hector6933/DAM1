import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio23 {

    public static void main(String[] args) {

        try (BufferedReader leerBufer = new BufferedReader(new FileReader("carpeta/Ej23/archivo.txt"));
             BufferedWriter writeBufer = new BufferedWriter(new FileWriter("carpeta/Ej23/archivo2.txt"))){

            String linea;
            while ((linea = leerBufer.readLine()) != null) {

                // (?i:hola) Hace que el regex no diferencie entre mayúsculas y minúsculas
                // También se puede poner (?i)hola pero esto afecta a todo lo que haya a la derecha de (i?)
                linea = linea.replaceAll("(?i:hola)","adios");
                writeBufer.write(linea + "\n");
            }

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");

        }

    }

}
