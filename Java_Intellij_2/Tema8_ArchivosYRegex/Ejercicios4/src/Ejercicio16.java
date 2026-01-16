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
                // Este regex solo sirve para este milenio
                // En caso de pasar al siguiente milenio cambiar en el apartado del año {1,4} -> {1,5}
                Matcher matcherFecha = Pattern.compile("([0-2][0-9]|3[0-1])/(0[0-9]|1[0-2])/[0-9]{1,4}").matcher(linea);
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
