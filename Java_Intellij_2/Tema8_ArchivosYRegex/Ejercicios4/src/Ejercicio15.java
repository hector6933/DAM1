import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio15 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.println("Introduce una dirección IP: ");
        System.out.print("> ");

        boolean ipCorrecta = Pattern.matches("^(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}$",leer.nextLine());

        if (ipCorrecta) {

            System.out.println("La IP es válida !");

        } else {

            System.out.println("La IP es INVÁLIDA !!!!!!!!!!!!!");

        }

        leer.close();

    }

}
