import java.util.Scanner;
public class Ejercicio3 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        boolean correcto = false;
        double num;
        do {

            System.out.println("Introduce un número: ");
            System.out.print("> ");
            if (leer.hasNextDouble()) {

                num = leer.nextDouble();
                leer.nextLine();
                System.out.println("La raíz cuadrada de " + num + " es " + Math.sqrt(num));
                correcto = true;

            } else {

                System.out.println("Número inválido !!!");
                leer.nextLine();

            }

        } while (!correcto);

        leer.close();

    }

}
