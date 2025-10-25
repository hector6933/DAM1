import java.util.Scanner;
public class Ejercicio15 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        boolean correcto = false;
        long numero;
        long resultado = 1;
        do {

            System.out.print("Introduce un número natural: ");
            if (leer.hasNextInt()) {

                numero = leer.nextLong();
                leer.nextLine();
                if (numero <= 0) {

                    System.out.println("El número debe de ser positivo y distinto de 0");

                } else {

                    for (int i = 1; i <= numero; i++) {

                        resultado = resultado * i;

                    }

                    System.out.println("El factorial de " + numero + " es " + resultado);
                    correcto = true;

                }

            } else {

                System.out.println("Eso NO es un número natural");
                leer.nextLine();

            }

        } while (!correcto);

    }

}
