import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Ejercicio8_AMiManera {

    public static void main(String[] args) {

        try {

            List<String> lineas = Files.readAllLines(Paths.get("carpeta/Ej8/Archivo.txt"));

            String[] palabras = lineas.toArray(new String[0]);

            int contadorPalabras = 0;

            for (int i = 0; i < palabras.length; i++) {
                int pos = 0;

                // Quito todos los espacios de la linea en la que estoy
                if (palabras[i].charAt(pos) == ' ') {

                    while (palabras[i].charAt(pos) == ' ') {

                        pos++;

                    }

                }

                while(pos < palabras[i].length()) {

                    if (palabras[i].charAt(pos) == ' ') {

                        while (palabras[i].charAt(pos) == ' ') {

                            pos++;

                        }

                        contadorPalabras++;

                    } else if (pos == palabras[i].length()-1) {

                        contadorPalabras++;
                        pos++;

                    } else {

                        pos++;

                    }

                }

            }

            System.out.println("El texto tiene " + contadorPalabras + " palabras");

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");

        }

    }

}
