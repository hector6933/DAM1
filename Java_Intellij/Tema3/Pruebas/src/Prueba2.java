import java.util.Scanner;
public class Prueba2 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        int numerin;
        boolean correcto = false;

        do {

            System.out.println("Dime un número: ");
            System.out.print("> ");

            try {

                numerin = Integer.parseInt(leer.nextLine());
                correcto = true;

            } catch (NumberFormatException e) {

                System.out.println("¡ Valor inválido !");

            }

            /*

            if (leer.hasNextInt()) {

                numerin = leer.nextInt();
                leer.nextLine();
                correcto = true;

            } else {

                System.out.println("Eso no es un entero");
                leer.nextLine();

            }
            */

        } while (!correcto);

    }

}
