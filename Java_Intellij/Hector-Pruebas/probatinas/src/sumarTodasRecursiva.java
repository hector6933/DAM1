import java.util.Scanner;
public class sumarTodasRecursiva {

    public static int sumar(int num) {

        if (num == 0) {

            return 0;

        } else if (num == 1) {

            return 1;

        } else {

            return num + sumar(num-1);

        }

    }

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        boolean correcto = false;
        int num;
        do {
            System.out.println("Introduce un número entero POSITIVO:");
            System.out.print("> ");
            try {

                num = Integer.parseInt(leer.nextLine());
                if (num < 0) {

                    System.out.println("El número DEBE de ser POSITIVO !!!");

                } else {

                    System.out.println("La suma de todas sus cifras es " + sumar(num));
                    correcto = true;

                }

            } catch (NumberFormatException e) {

                System.out.println("Número inválido !!!");

            }

        } while (!correcto);

    }

}
