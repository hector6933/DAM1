import java.util.Scanner;
public class Ejercicio14 {

    public static int sumaCifras(int num) {

        if (num == 0) {

            return 0;

        } else if (num == 1) {

            return 1;

        } else {

            return num + sumaCifras(num-1);

        }

    }

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        boolean correcto = false;
        int num = 0;
        do {
            System.out.println("Introduce un número entero positivo");
            try {

                num = Integer.parseInt(leer.nextLine());
                if (num < 0) {

                    System.out.println("El númro debe de ser positivo !!!");

                } else {

                    System.out.println("La suma de las cifras de " + num + " es: " + sumaCifras(num));
                    correcto = true;

                }

            } catch (NumberFormatException e) {

                System.out.println("Eso NO es un número entero válido !!!");

            }

        } while (!correcto);


    }

}
