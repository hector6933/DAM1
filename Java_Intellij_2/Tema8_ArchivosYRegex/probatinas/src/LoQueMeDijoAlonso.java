import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoQueMeDijoAlonso {

    public static void main(String[] args) {

        String texto = "Hola soy un texto, hola soy una palAbrA con dos mayúsculas !!!";

        Matcher matcherMayus = Pattern.compile("(?=\\S[])").matcher(texto);

        while (matcherMayus.find()) {

            System.out.println("Palabra con dos mayúsculas encontrada: " + matcherMayus.group());

        }

    }

}
