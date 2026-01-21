import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio24Old {

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

            for (int i = 0; i < contadorPalabras; i++) {

                regex.append("(\\S*\\w+\\S*)");

            }

            for (int i = contadorPalabras; i > 0; i--) {

                if (i == 1) {

                    regex2.append("$" + i);

                } else {

                    regex2.append("$" + i + " ");

                }

            }
            System.out.println(archivo);
            System.out.println("-----------------------------");
            System.out.println(regex);
            System.out.println(regex2);

            String prueba = "hola1 hola2 hola3";
            String probRegex1 = "(\\b\\w+\\b) (\\b\\w+\\b) (\\b(\\w+)\\b)";
            String probRegex2 = "$3 $2 $1";
            String texto2 = prueba.replaceAll(probRegex1,probRegex2);

            // String texto2 = archivo.replaceAll(regex.toString(),regex2.toString());
            System.out.println(texto2);

            System.out.println("-----------------");
            System.out.println(contadorPalabras);

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura / escritura del archivo !!!");

        } catch (Exception e) {

            System.out.println(e);

        }

    }

}