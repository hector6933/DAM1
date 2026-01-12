import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio13 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.println("Introduce tu número de teléfono formato (xxx-xxx-xxxx): ");
        System.out.print("> ");

        Matcher patronTelefono = Pattern.compile("^[0-9]{3}-[0-9]{3}-[0-9]{4}$").matcher(leer.nextLine());

        if (patronTelefono.find()) {

            System.out.println("Telefóno válido !");

        } else {

            System.out.println("Teléfono INVÁLIDO !!!!!!!!!");

        }

        leer.close();

    }

}
