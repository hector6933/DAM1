import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio24Regex {

    public static void main(String[] args) {

        try (BufferedWriter writeBufer = new BufferedWriter(new FileWriter("carpeta/Ej24_2/archivo2.txt"));) {

            String archivo = Files.readString(Path.of("carpeta/Ej24_2/archivo.txt"));

            String texto = "hola hola2";

            StringBuilder regex = new StringBuilder();
            StringBuilder regex2 = new StringBuilder();

            Matcher matcherPalabras = Pattern.compile("\\b\\w+\\b").matcher(archivo);
            int contadorPalabras = 0;

            while (matcherPalabras.find()) {

                contadorPalabras++;

            }

            for (int i = 1; i < contadorPalabras; i++) {

                regex.append("(\\S*\\w+\\S*)");
//                if (i == contadorPalabras-1) {
//
//                    regex.append("(\\w+)");
//
//                }

            }

            for (int i = contadorPalabras; i > 0; i--) {

                regex2.append("$" + i + " ");
                if (i == 1) {

                    regex2.append("$" + i);

                }

            }

            String texto2 = archivo.replaceAll(regex.toString(),regex2.toString());

            System.out.println(texto2);

            System.out.println("-----------------");

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura / escritura del archivo !!!");

        } catch (Exception e) {

            System.out.println(e);

        }

    }

}
