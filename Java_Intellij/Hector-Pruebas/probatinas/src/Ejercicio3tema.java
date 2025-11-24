import java.util.Scanner;
public class Ejercicio3tema {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        char caracter;

        System.out.println("Introduce UN carácter");
        if (leer.hasNextInt()) {

            System.out.println("Has introducido un número");
            leer.nextLine();
        } else {

            caracter = leer.next().charAt(0);
            leer.nextLine();
            if ((caracter >= 'A' && caracter <= 'Z') || (caracter >= 'a' && caracter <= 'z')) {

                System.out.println("Has introducido un carácter alfabético");

            } else {

                System.out.println("Has introducido otro tipo de carácter");

            }

        }

    }

}
