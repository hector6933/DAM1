import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicio8_conSplit {

    public static void main(String[] args) {

        try (BufferedReader leer = new BufferedReader(new FileReader("carpeta/Ej8/Archivo.txt"))){

            StringBuilder contenidoFichero = new StringBuilder();
            String linea;
            while ((linea = leer.readLine()) != null) {

                contenidoFichero.append(linea);

            }
            String a = contenidoFichero.toString();

            ArrayList<String> palabras = new ArrayList<>(Arrays.stream(a.split(" ")).toList());
            int vacio = 0;
            for (int i = 0; i < palabras.size(); i++) {

                if (palabras.get(i).isEmpty() || palabras.get(i).isBlank()) {

                    palabras.remove(i);
                    i--;

                }

            }
            System.out.println("El texto tiene " + palabras.size() + " palabras");

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");

        }

    }

}
