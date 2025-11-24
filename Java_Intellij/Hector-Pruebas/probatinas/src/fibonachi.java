import java.util.Scanner;
public class fibonachi {

    public static int fibo(long num) {

        if (num == 0) {

            return 0;

        } else if (num == 1) {

            return 1;

        } else {

            return fibo(num-1) + fibo(num-2);

        }

    }

    public static void main(String[] args) {

            Scanner leer = new Scanner(System.in);
            boolean correcto = false;
            long num;

            do {

                System.out.println("Introduce un número entero POSITIVO:");
                System.out.print("> ");
                try {

                    num = Long.parseLong(leer.nextLine());
                    if (num < 0) {

                        System.out.println("El número DEBE de ser POSITIVO !!!");

                    } else {

                        System.out.println("Numerin: " + fibo(num));
                        correcto = true;

                    }

                } catch (NumberFormatException e) {

                    System.out.println("Número inválido !!!");

                }

            } while (!correcto);

            leer.close();

    }

}
