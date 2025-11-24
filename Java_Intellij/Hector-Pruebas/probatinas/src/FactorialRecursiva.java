import java.util.Scanner;
public class FactorialRecursiva {

    public static long facto(long num) {

        if (num == 0) {

            return 0;

        } else if (num == 1) {

            return 1;

        } else {

            if (num > 0) {

                return num * facto(num-1);

            } else {

                if (num % 2 == 0) {

                    return facto(-num);

                } else {

                    return - facto(-num);

                }

            }


        }

    }

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        boolean correcto = false;
        long num;

        do {
            System.out.println("Introduce un número entero y te digo su factorial:");
            System.out.print("> ");
            try {

                num = Long.parseLong(leer.nextLine());
                if (false) {

                    System.out.println("El número tiene que ser POSITIVO");

                } else {

                    System.out.println("El factorial de " + num + " es: " + facto(num));
                    correcto = true;

                }

            } catch (NumberFormatException e) {

                System.out.println("Número inválido !!!");

            }

        } while (!correcto);

    }

}
