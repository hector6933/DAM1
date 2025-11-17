import java.util.Scanner;
public class Ejercicio13 {

    public static int fibonnacci(int numero) {

        if (numero == 0) {

            return 0;

        } else if (numero == 1) {

            return 1;

        } else {

            return fibonnacci(numero-1) + fibonnacci(numero-2);

        }

    }

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        boolean correcto = false;
        do {
            System.out.println("Dime la posición de Fibonacci que quieres saber: ");
            System.out.print("> ");
            try {

                int num = Integer.parseInt(leer.nextLine());
                System.out.println("La posición " + num + " de fibonacci es: " + fibonnacci(num));
                correcto = true;


            } catch (NumberFormatException e) {

                System.out.println("Introduce un número entero válido !!!");

            }

        } while (!correcto);

    }

}
