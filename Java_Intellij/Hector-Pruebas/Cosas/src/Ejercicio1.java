import java.util.Scanner;
public class Ejercicio1 {

    public static void main() {

        Scanner leer = new Scanner(System.in);

        System.out.println("Introduce tu nombre:");
        System.out.print("> ");
        String nombre = leer.next();

        System.out.println("Hola " + nombre + " !!!");

        leer.close();

    }

}
