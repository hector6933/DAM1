import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio12 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.println("Introduce el email: ");
        System.out.print("> ");

        Matcher patronCorreo = Pattern.compile("^[\\w]+@[\\w]+\\.[a-zA-Z]{2,}$").matcher(leer.nextLine());

        if (patronCorreo.find()) {

            System.out.println("Correo válido !");

        } else {

            System.out.println("Correo INVÁLIDO !!!!!!!");

        }

        leer.close();

    }

}
