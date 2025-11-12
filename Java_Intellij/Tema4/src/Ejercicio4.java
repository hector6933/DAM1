import java.util.Scanner;
public class Ejercicio4 {

    public static void tabla(int numero) {

        for (int i = 1; i <= 10 ; i++) {

            System.out.println(numero + " x " + i + " = " + (numero*i));

        }

    }

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        boolean correcto = false;
        int numero = 0;
        do {

            System.out.println("Introduce un número entero: ");
            System.out.print("> ");

            try {

                numero = Integer.parseInt(leer.nextLine());
                correcto = true;

            } catch (NumberFormatException e) {

                System.out.println("Número entero inválido !!!");

            }

        } while (!correcto);

        tabla(numero);

        leer.close();
    }

}
