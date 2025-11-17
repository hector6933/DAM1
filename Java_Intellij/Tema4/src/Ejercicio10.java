import java.util.Scanner;
public class Ejercicio10 {

    public static void factorial(int num) {

        int total = 1;
        for (int i = 1; i <= num; i++) {

            total = total * i;

        }
        System.out.println("El factorial de " + num + " es: " + total);

    }

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        boolean correcto = false;

        do {

            System.out.println("Introduce un número entero: ");
            System.out.print("> ");
            try {

                int num = Integer.parseInt(leer.nextLine());
                factorial(num);
                correcto = true;

            } catch (NumberFormatException e) {

                System.out.println("Eso NO es un número entero válido !!!");

            }

        } while (!correcto);

    }

}
