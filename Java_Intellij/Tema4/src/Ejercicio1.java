import java.util.Scanner;
public class Ejercicio1 {

    public static int signo(double numerin) {

        if (numerin < 0) {

            return -1;

        } else if (numerin > 0) {

            return 1;

        } else {

            return 0;

        }

    }

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        double numero = 0;
        boolean correcto = false;
        do {
            System.out.println("Dime un número real");
            System.out.print("> ");
            try {

                numero = Double.parseDouble(leer.nextLine());
                correcto = true;

            } catch (NumberFormatException e) {

                System.out.println("Número real inválido !!!");

            }

        } while (!correcto);

        System.out.println("Resultado: " + signo(numero));

        leer.close();

    }

}
