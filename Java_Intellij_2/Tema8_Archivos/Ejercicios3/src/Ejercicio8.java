import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio8 {

    public static void main(String[] args) {

        // POR HACER, ARREGLAR EL OUT OF BOUNDS
        try (BufferedReader leer = new BufferedReader(new FileReader("carpeta/Ej8/Archivo.txt"))) {

            String linea;
            int palabras = 0;

            while ( (linea = leer.readLine()) != null) {

                int i = 0;


                while (linea.charAt(i) == ' ' ) {

                    i++;

                }

                for ( ; i < linea.length(); i++) {

                    if (linea.charAt(i) == ' ') {

                        palabras++;
                        while (linea.charAt(i+1) == ' ' ) {

                            i++;

                        }

                    }

                }


            }

            System.out.println("Hay un total de " + palabras + " palabras");

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");

        }

    }

}
