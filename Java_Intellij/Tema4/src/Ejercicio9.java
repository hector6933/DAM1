import java.util.Scanner;
public class Ejercicio9 {

    public static int cuentaAtras(int numero) {

        System.out.println(numero);
        if (numero == 0) {

            return 0;

        } else {

            return cuentaAtras(numero-1);

        }

    }

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        boolean correcto = false;

        do {
            System.out.println("Introduce un número ENTERO POSITIVO para la cuenta atrás:");
            System.out.print("> ");
            try {

                int num = Integer.parseInt(leer.nextLine());
                if (num < 0) {

                    System.out.println("El número debe de ser positivo");

                } else {

                    cuentaAtras(num);
                    correcto = true;

                }
                // Llamar a la funcion

            } catch (NumberFormatException e) {

                System.out.println("Eso NO es un entero válido !!!");

            }

        } while (!correcto);

        leer.close();
    }

}
