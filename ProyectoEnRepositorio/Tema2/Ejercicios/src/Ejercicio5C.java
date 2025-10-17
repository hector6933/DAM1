import java.util.Scanner;

public class Ejercicio5C {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.print("Dime el número mínimo: ");
        int numMin = leer.nextInt();

        System.out.print("Dime el número máximo: ");
        int numMax = leer.nextInt();
        if (numMin > numMax) {

            System.out.println("El número mínimo NO puede ser mayor al máximo");

        } else if (numMin == numMax) {

            System.out.println("Solamente puede salir el " + numMin);

        } else {

            for (int i = 0; i < 3; i++) {

                int random = (int) (Math.random() * (numMax - numMin) + numMin);

                System.out.println("El número random " + (i+1) + " es: " + random);

            }

        }



    }

}
