import java.util.Scanner;
public class Ejercicio11 {

    public static int factorial(int num) {

        if (num == 0) {

            return 0;

        } else if (num == 1) {

            return 1;

        } else {

            return num * factorial(num-1);

        }

    }

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        boolean correcto = false;

        do {

            System.out.println("Introduce un número entero: ");
            System.out.print("> ");
            try {

                int num = Integer.parseInt(leer.nextLine());
                System.out.println("El factorial de " + num + " es: " + factorial(num));
                correcto = true;

            } catch (NumberFormatException e) {

                System.out.println("Eso NO es un número entero válido !!!");

            }

        } while (!correcto);

    }

}
