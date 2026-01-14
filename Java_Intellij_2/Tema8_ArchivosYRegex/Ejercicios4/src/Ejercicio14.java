import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio14 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.println("Introduce una frase: ");
        System.out.print("> ");

        Matcher comenzarMayus = Pattern.compile("\\b[A-ZÑ][\\wñÑ]+\\b").matcher(leer.nextLine());

        System.out.println("Palabras que empiezan por mayúsculas: ");
        while (comenzarMayus.find()){

            System.out.print(comenzarMayus.group() + " | ");

        }

        leer.close();
    }

}
