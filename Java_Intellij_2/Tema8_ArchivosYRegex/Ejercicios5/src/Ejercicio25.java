import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio25 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        int contador = 0;

        System.out.println("Introduce una palabra:");
        System.out.print("> ");
        String palabra = leer.next();
        leer.nextLine();

        try (BufferedReader leerBufer = new BufferedReader(new FileReader("carpeta/Ej25/archivo.txt"))){

            String linea;
            while ((linea = leerBufer.readLine()) != null) {

                Matcher patronPalabra = Pattern.compile("(?i)" + palabra).matcher(linea);
                if (patronPalabra.find()) {

                    contador++;

                }
            }

            System.out.println("La palabra aparece en " + contador + " líneas del archivo");

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");

        }

        leer.close();
    }

}
