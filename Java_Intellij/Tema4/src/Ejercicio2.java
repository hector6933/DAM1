import java.util.Scanner;
public class Ejercicio2 {

    public static int calcularMenor(int num1, int num2) {

        return Math.min(num1,num2);

    }

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        boolean correcto = false;
        do {
            System.out.println("Introduce un número entero");
            System.out.print("> ");
            try {

                num1 = Integer.parseInt(leer.nextLine());
                do {
                    System.out.println("Introduce otro número entero");
                    System.out.print("> ");
                    try {

                        num2 = Integer.parseInt(leer.nextLine());
                        correcto = true;

                    } catch (NumberFormatException e) {

                        System.out.println("Número entero inválido !!!");

                    }

                } while (!correcto);


            } catch (NumberFormatException e) {

                System.out.println("Número entero inválido !!!");

            }

        } while (!correcto);

        System.out.println("El menor de los dos es: " + calcularMenor(num1,num2));

        leer.close();

    }

}
