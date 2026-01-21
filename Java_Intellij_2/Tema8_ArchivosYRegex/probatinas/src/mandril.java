import java.rmi.MarshalException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mandril {

    public static void main(String[] args) {

        String cadena = "Hol@a@ soy and@@res y me gústá programacion";

        Pattern patron = Pattern.compile("(?=\\S*[^A-Za-z0-9\\s](?=\\S*[^A-Za-z0-9\\s]))\\S*");
        Matcher matcher = patron.matcher(cadena);

        while (matcher.find()){
            System.out.println("Coincidencia encontrada: " + matcher.group());
        }

    }

}
