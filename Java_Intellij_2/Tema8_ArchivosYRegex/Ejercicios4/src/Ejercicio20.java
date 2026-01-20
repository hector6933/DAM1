import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio20 {

    public static void main(String[] args) {

        try {

            // \S* Coincide con todo lo que NO son espacios/bordes o EXACTAMENTE nada

            // Por ejemplo:
            // hola$
            // NO coincide con el primer espacio, luego empieza a coincidir con la H hasta llegar al dólar y luego coincide con exactamente NADA

            // Por ejemplo:
            // C@lam@res
            // No coincide con el primer espacio, empieza a coincidir con la C --> \\S* luego con el arroba --> [$%&#@]
            // y luego con todo lo demás hasta llegar al final donde coincide hasta llegar al borde o a un espacio
            Matcher patronCaracteres = Pattern.compile("\\S*[$%&#@]\\S*").matcher(Files.readString(Path.of("carpeta/Ej20/archivo.txt")));
            //
            while (patronCaracteres.find()) {

                System.out.println("Palabra encontrada: " + patronCaracteres.group());

            }

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");

        }



    }

}
