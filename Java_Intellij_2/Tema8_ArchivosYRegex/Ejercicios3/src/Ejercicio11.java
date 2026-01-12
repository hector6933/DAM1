import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio11 {

    public static void main(String[] args) {

        int iterador = 0;
        String cadena = "   hola      que tal ttt      aqui        hay espacios         sobrantes";

        Matcher espacios = Pattern.compile("\\b \\b").matcher(cadena);
        cadena = cadena.trim();
        String cadenaBuena = cadena.replaceAll("\\b[ ]{2,}\\b"," ");

        System.out.println(cadenaBuena);

    }

}
