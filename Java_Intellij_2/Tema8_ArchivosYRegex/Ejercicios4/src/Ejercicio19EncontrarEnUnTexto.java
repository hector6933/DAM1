import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio19EncontrarEnUnTexto {

    public static void main(String[] args) {

        String texto = "Hola soy t9cmkdWakl#tor y esta es mi contraseña: holaholA1#HECTOR Hola soy Alonso y esta es mi contraseña: holaholA2#ALONSO";
        String validPass = "holaholA1#";

        // boolean validarPass = Pattern.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[$%#@&/])\\S{8,}$", validPass);

        Matcher matcherPass = Pattern.compile("(?=\\S*[A-Z])(?=\\S*[0-9])(?=\\S*[$%#@&/])\\S{8,}").matcher(texto);

        while (matcherPass.find()) {

            System.out.println("Contraseña válida encontrada: " + matcherPass.group());

        }

    }

}
