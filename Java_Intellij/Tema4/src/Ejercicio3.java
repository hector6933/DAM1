import java.util.Scanner;
public class Ejercicio3 {

    public static int elevar(int base, int potencia) {

        int total = 1;

        for (int i = 0; i < potencia; i++) {

            total = total * base;

        }
        return total;
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

                    System.out.println("Introduce la potencia a elevar: ");
                    System.out.print("> ");
                    try {

                        num2 = Integer.parseInt(leer.nextLine());
                        correcto = true;

                    } catch (NumberFormatException e) {

                        System.out.println("Número entero inválido !!!");

                    }

                } while (!correcto);

            } catch (NumberFormatException e) {

                System.out.println("Número entero inválido !!!");

            }

        } while (!correcto);

        System.out.println(num1 + " elevado a " + num2 + " es: " + elevar(num1,num2));

        leer.close();

    }

}
