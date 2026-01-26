import javax.annotation.processing.SupportedAnnotationTypes;
import java.util.Scanner;

public class probatina4 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        try {

            System.out.println("Introduce un número para dividir por 100");
            System.out.print("> ");
            int numero = Integer.parseInt(leer.nextLine());

            if (numero == 0) {

                throw new ArithmeticException("División por cero");

            }

        } catch (IllegalArgumentException e) {

            System.out.println("Número inválido !!!");

        } catch (ArithmeticException e) {

            e.printStackTrace();

        }

    }

}
