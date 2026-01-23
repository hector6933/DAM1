import java.util.Scanner;

public class probatina2 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        try {

            throw new IllegalArgumentException("Argumento inválido!");

        } catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());

        }

        leer.close();

    }

}
