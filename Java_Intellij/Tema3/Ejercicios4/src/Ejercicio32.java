import  java.util.Scanner;
public class Ejercicio32 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        boolean correcto = false;
        int numero = 0;
        do {

            System.out.print("Dime un número entero positivo: ");
            if (leer.hasNextInt()) {

                numero = leer.nextInt();
                leer.nextLine();
                if (numero < 0) {

                    System.out.println("Tiene que ser un número positivo");

                } else {

                    correcto = true;

                }
            } else {

                System.out.println("Eso NO es un número entero válido");
                leer.nextLine();

            }

        } while (!correcto);

        System.out.println("Divisores de " + numero + ":");
        for (int i = 1; i < numero; i++) {

            if (numero % i == 0) {

                System.out.println(i);

            }

        }

    }

}
