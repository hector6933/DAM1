import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio14 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.println("Introduce una frase: ");
        System.out.print("> ");

        Matcher comenzarMayus = Pattern.compile("").matcher(leer.nextLine());

        leer.close();
    }

}
