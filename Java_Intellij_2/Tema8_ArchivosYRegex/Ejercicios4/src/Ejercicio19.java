import java.util.Scanner;
import java.util.regex.Pattern;

public class Ejercicio19 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.println("Introduce tu contraseña: ");
        System.out.print("> ");

        Boolean validarPass = Pattern.matches("^[\\w]+[A-Z]+[0-9]+[\\W]++$",leer.nextLine());

        if (validarPass) {

            System.out.println("Contraseña válida !");

        } else {

            System.out.println("Contraseña INVÁLIDA !!!");

        }


        leer.close();
    }

}
