import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Ejercicio8 {

    public static void main(String[] args) {

        try {

            List<String> lineas = Files.readAllLines(Paths.get("carpeta/Ej8/Archivo.txt"));

            String[] palabras = lineas.toArray(new String[0]);

            int contadorPalabras = 0;

            for (int i = 0; i < palabras.length; i++) {
                int pos = 0;

                if (palabras[i].charAt(pos) == ' ') {

                    while (palabras[i].charAt(pos) == ' ') {

                        pos++;

                    }

                }

                for (int j = 0; j < palabras[i].length(); j++) {

                    if (palabras[i].charAt(pos) == ' ') {

                        while (palabras[i].charAt(pos) == ' ') {

                            pos++;

                        }

                        contadorPalabras++;

                    } else if (j == palabras[i].length()-1) {

                        contadorPalabras++;


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
