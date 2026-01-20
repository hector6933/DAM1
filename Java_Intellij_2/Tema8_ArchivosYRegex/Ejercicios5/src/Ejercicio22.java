import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio22 {

    public static void main(String[] args) {

        try (BufferedReader leerBufer = new BufferedReader(new FileReader("carpeta/Ej22/archivo.txt"))){

            String linea;
            int contador = 0;
            while ((linea = leerBufer.readLine()) != null) {

                Matcher patronPalabra = Pattern.compile("\\b\\w+\\b").matcher(linea);

                while (patronPalabra.find()) {

                    contador++;

                }

            }

            System.out.println("Hay un total de " + contador + " palabras");

        } catch (FileNotFoundException e){

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");

        }

    }

}
