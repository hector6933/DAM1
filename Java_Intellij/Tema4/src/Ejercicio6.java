import java.util.Scanner;
public class Ejercicio6 {

    public static double mediaAritmetica(int num1, int num2) {

        return (num1 + num2) / 2;
    }

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        boolean correcto = false;
        int num1 = 0;
        int num2 = 0;
        do {
            System.out.println("Introduce un número entero: ");
            System.out.print("> ");
            try {

                num1 = Integer.parseInt(leer.nextLine());

                do {
                    System.out.println("Introduce otro número entero: ");
                    System.out.print("> ");
                    try {

                        num2 = Integer.parseInt(leer.nextLine());
                        correcto = true;

                    } catch (NumberFormatException e) {

                        System.out.println("Número inválido !!!");

                    }

                } while (!correcto);

            } catch (NumberFormatException e) {

                System.out.println("Número inválido !!!");

            }

        } while (!correcto);

        System.out.println("La media aritmética es " + mediaAritmetica(num1, num2));

    }

}
