import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;

public class Ejercicio6 {

    public static void main(String[] args) {

        int contador = 0;

        try (FileReader leer = new FileReader("carpeta/Ej6/archivo.txt")){

            int caracter;
            System.out.println("------------------------");
            while ((caracter = leer.read()) != -1) {

                System.out.print((char) caracter);

                if ( ((char) caracter) == 'a' || ((char) caracter) == 'A'  ) {

                    contador++;

                }

            }
            System.out.println();
            System.out.println("------------------------");
            System.out.println("La letra 'a' aparece " + contador + " veces");

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");

        }


    }

}
