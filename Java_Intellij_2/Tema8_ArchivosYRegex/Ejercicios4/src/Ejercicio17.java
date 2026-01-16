import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio17 {

    public static void main(String[] args) {

        try (BufferedReader leerBufer = new BufferedReader(new FileReader("carpeta/Ej17/archivo.txt"))){

            String linea;

            while ((linea = leerBufer.readLine()) != null) {

                // Matcher encontrarNumero = Pattern.compile("\\d+|\\d+\\.\\d+|\\d+,\\d+").matcher(linea);
                Matcher encontrarNumero = Pattern.compile("(\\d+\\.\\d+|\\d+,\\d+|\\d+)").matcher(linea);

                while (encontrarNumero.find()) {

                    System.out.println("Número encontrado: " + encontrarNumero.group());

                }

            }


        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");

        }

    }

}
