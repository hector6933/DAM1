import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio7 {

    public static void main(String[] args) {

        int abc = 65;

        while (abc != 90) {

            try (FileReader leer = new FileReader("carpeta/Ej7/archivo.txt")) {

                int letras;

                int contador = 0;
                while ((letras = leer.read()) != -1) {

                    if (letras == abc || letras == (abc + 32)) {

                        contador++;

                    }

                }

                // Si la letra no aparece por lo menos 1 vez ni tan siquiera me molesto en mostrarla por pantalla
                if (contador >= 1) {

                    System.out.println("La letra " + (char) abc + " aparece: " + contador + " veces.");

                }

                abc++;

            } catch (FileNotFoundException e) {

                System.out.println("Archivo NO encontrado");

            } catch (IOException e) {

                System.out.println("Error en la lectura del archivo");

            }

        }

    }

}
