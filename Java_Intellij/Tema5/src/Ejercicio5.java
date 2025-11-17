import java.util.Scanner;
public class Ejercicio5 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        int[] randoms = new int[10];

        int pos = 0;

        for (int i = 0; i < 100; i++) {

            randoms[i] = (int) (Math.random() * 100);

        }

        do {
            System.out.println("Introduce un número entero y te digo si está en el array (Numero negativo para salir)");
            try {

                pos = Integer.parseInt(leer.nextLine());
                if (pos >= 0) {



                }

            } catch (NumberFormatException e) {

                System.out.println("Eso NO es un número entero válido");

            }


        } while (pos > 0);

    }

}
