import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoQueMeDijoAlonso {

    public static void main(String[] args) {

        // Este regex está hecho para que encuentre palabras con DOS mayúsculas
        // En cuanto el primer LookAhead encuentre la primera coincidencia el segundo buscará a partir de ese
        String texto = "Hola soy un texto, hola soy una palAbrA con dos mayúsculas AlonsO TeTas!!! TETas";

        Matcher matcherMayus = Pattern.compile("(?=\\S*[A-Z](?=\\S*[A-Z]))\\S*").matcher(texto);

        while (matcherMayus.find()) {

            System.out.println("Palabra con dos mayúsculas encontrada: " + matcherMayus.group());

        }

    }

}
