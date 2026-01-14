import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio16 {

    public static void main(String[] args) {

        boolean encontrado = false;
        try (BufferedReader leerBufer = new BufferedReader(new FileReader("carpeta/Ej16/archivo.txt"))){

            String linea;


            while ((linea = leerBufer.readLine()) != null) {

                System.out.println(linea);

                Matcher matcherFecha = Pattern.compile(linea).matcher("\\b(0[1-9]|[10-30])/hola\\b");
                while (matcherFecha.find()) {

                    System.out.println("Fecha válida encontrada: " + matcherFecha.group());
                    encontrado = true;

                }
            }

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");

        }

        System.out.println("-----------------------------------------------");
        if (!encontrado) {

            System.out.println("Ninguna fecha válida encontrada...");

        }

    }

}
