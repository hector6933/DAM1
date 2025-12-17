import java.io.BufferedReader;
import java.io.FileReader;

public class Ejercicio6 {

    public static void main(String[] args) {

        int contador = 0;

        try (FileReader leer = new FileReader("carpeta/Ej6/archivo.txt")) {

            int caracter;

            if ( (caracter = leer.read()) != -1) {

                if ( ((char) caracter) == 'a' || ((char) caracter) == 'A'  ) {

                    contador++;

                }

            }


        } catch (Exception e) {

            System.out.println("Error en la lectura del archivo !!!");

        }

        System.out.println("La letra 'a' aparece " + contador + " veces");
    }

}
