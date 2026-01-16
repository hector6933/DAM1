import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio18 {

    public static void main(String[] args) {

        String texto = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata tetas";

        Matcher encontrarPalabras = Pattern.compile("\\b[a-zA-Z]{5}\\b").matcher(texto);

        while (encontrarPalabras.find()) {

            System.out.println("Palabra de 5 letras encontrada: " + encontrarPalabras.group());

        }




    }

}
