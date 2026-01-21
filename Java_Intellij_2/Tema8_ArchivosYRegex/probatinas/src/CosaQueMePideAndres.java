import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CosaQueMePideAndres {

    public static void main(String[] args) {

        String cadena = "La salchicha kranjska java klobasa o salchicha java de lenguaje java.Carniola es javaun plato tradicional de Eslovenia,lenguaje java.preparada con carne de cerdo ahumada, ajo, pimienta y sal, siguiendo una receta de fines del siglo";

        Pattern patron = Pattern.compile("");
        Matcher matcher = patron.matcher(cadena);

        while (matcher.find()){
            System.out.println("Coincidencia encontrada: " + matcher.group());
        }

    }

}
