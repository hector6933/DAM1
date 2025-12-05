import java.util.Scanner;

public class Ejercicio22 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.println("Introduce una frase: ");
        System.out.print("> ");
        String frase = leer.nextLine();

        System.out.println(frase.toUpperCase().trim());
        System.out.println(frase.toLowerCase().trim());

        String[] palabras = frase.split(" ");

        StringBuilder palabrasBuilder = new StringBuilder(frase);

        palabrasBuilder.setCharAt(0,palabrasBuilder.toString().toUpperCase().charAt(0));
        try {

            for (int i = 0; i < palabrasBuilder.length(); i++) {

                if (palabrasBuilder.charAt(i) == ' ') {

                    palabrasBuilder.setCharAt(i+1,palabrasBuilder.toString().toUpperCase().charAt(i+1));

                }

            }

        } catch (Exception e) {


        }


        System.out.println(palabrasBuilder);

        leer.close();

    }

}
