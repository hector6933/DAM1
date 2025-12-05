import java.util.Scanner;

public class Ejercicio21 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        int contador = 0;

        System.out.println("Introduce una frase: ");
        System.out.print("> ");
        String frase = leer.nextLine();

        for (int i = 0; i < frase.length(); i++) {

            if (frase.toLowerCase().charAt(i) == 'a') {

                contador++;
                System.out.println("a Pos: " + i);

            }

            if (frase.toLowerCase().charAt(i) == 'á') {

                contador++;
                System.out.println("á Pos: " + i);

            }

        }

        System.out.println("Hay " + contador + " a");

        leer.close();

    }
}
