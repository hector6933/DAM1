import java.util.Scanner;
public class Ejercicio30 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        boolean correcto = false;
        int altura = 0;
        int longitud = 1;
        do {

            System.out.print("Introduce la altura del triángulo: ");
            if (leer.hasNextInt()) {

                altura = leer.nextInt();
                leer.nextLine();
                if (altura <= 0) {

                    System.out.println("La altura debe de ser un número entero positivo y mayor que 0");

                } else {

                    correcto = true;

                }

            } else {

                System.out.println("La altura debe de ser un número entero positivo");
                leer.nextLine();

            }
        } while (!correcto);

        for (int i = 0; i < altura; i++) {

            for (int j = 0; j < longitud; j++) {

                System.out.print("*");

            }
            longitud +=1;
            System.out.println(" ");

        }

    }

}
