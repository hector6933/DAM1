import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        System.out.print("Escribe lo que sea: ");
        if (leer.hasNextDouble() && !leer.hasNextInt()) {

            System.out.println("Has introducido un número real");


        } else if (leer.hasNextInt()) {

            System.out.println("Has introducido un número entero");

        } else if (leer.hasNext()) {

            System.out.println("Has introducido caracteres");

        }
        leer.nextLine();


    }

}
