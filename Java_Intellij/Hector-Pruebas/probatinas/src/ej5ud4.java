import java.util.Scanner;
public class ej5ud4 {

    public static void triangulo(int num, char letra) {

        int filas = num;
        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < num; j++) {

                System.out.print(letra);

            }
            num--;
            System.out.println(" ");

        }

    }

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        boolean correcto = false;
        int num;
        char letra;
        do {

            System.out.println("Introduce un número entero POSITIVO:");
            System.out.print("> ");
            try {

                num = Integer.parseInt(leer.nextLine());
                if (num < 0) {

                    System.out.println("Debe de ser POSITIVO !!!");

                } else {

                    System.out.println("Introduce un carácter:");
                    System.out.print("> ");
                    letra = leer.next().charAt(0);
                    triangulo(num,letra);
                    correcto = true;

                }

            } catch (NumberFormatException e) {

                System.out.println("Número inválido !!!");

            }

        } while (!correcto);

    }

}
