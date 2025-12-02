import java.util.Scanner;
public class Ejercicio4_2 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        boolean correcto = false;
        int numero;
        int random;
        do {

            System.out.println("Introduce un número entero positivo: ");
            System.out.print("> ");
            if (leer.hasNextInt()) {

                numero = leer.nextInt();
                leer.nextLine();
                if (numero < 0) {

                    System.out.println("El número DEBE de ser positivo !!!");

                } else {

                    correcto = true;
                    for (int i = 0; i < 100; i++) {

                        System.out.println((int) (Math.random() * (numero + 1)));

                    }

                }

            } else {

                System.out.println("Número inválido !!!");
                leer.nextLine();

            }

        } while (!correcto);


        leer.close();

    }

}
