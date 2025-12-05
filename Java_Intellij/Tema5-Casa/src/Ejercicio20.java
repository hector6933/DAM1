import java.util.Scanner;

public class Ejercicio20 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        int contador = 0;

        System.out.println("Introduce una frase: ");
        System.out.print("> ");
        String frase = leer.nextLine();

        for (int i = 0; i < frase.length(); i++) {

            if (frase.toLowerCase().charAt(i) == 's') {

                contador++;
                System.out.println("s Pos: " + i);

            }

        }

        System.out.println("Hay " + contador + " s");

        leer.close();

    }

}
