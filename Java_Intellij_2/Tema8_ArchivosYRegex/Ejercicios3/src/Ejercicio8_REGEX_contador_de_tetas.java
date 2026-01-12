import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio8_REGEX_contador_de_tetas {

    public static void main(String[] args) {

        try (BufferedReader leer = new BufferedReader(new FileReader("carpeta/Ej8/Archivo.txt"))){

            int palabras = 0;
            //Pattern patronPalabra = Pattern.compile("[a-zA-Z]+");
            Pattern patronPalabra = Pattern.compile("\\(\\.\\)\\(\\.\\)"); // Patron de tetas, boff
            String linea;
            while ((linea = leer.readLine()) != null) {

                Matcher coincidir = patronPalabra.matcher(linea);
                for (int i = 0; i < linea.length(); i++) {

                    if (coincidir.find()) {

                        palabras++;

                    }

                }

            }

            System.out.println("El texto tiene " + palabras + " pares de TETAS");

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");

        }

    }

}
