import java.util.Scanner;
// Probando funciones
// Programa protegido contra:
//      - Usuario tonto
//      - Profesor cabrón
public class pruebaFuncion {

    static Scanner leer = new Scanner(System.in);


    public static int pedirInt() {

        boolean salir = false;
        do {
            System.out.print("Introduce un número entero: ");
            if (leer.hasNextInt()) {

                salir = true;
                return leer.nextInt();

            } else {

                System.out.println("Eso no es un número entero válido");
                leer.nextLine();

            }
        } while (!salir);

        return 0;

    }

    public static void main(String[] args) {


        int num1;
        int num2 = 0;

        num1 = pedirInt();
        leer.nextLine();

        System.out.println("El número es " + num1);

        num2 = pedirInt();
        leer.nextLine();

        System.out.println("El número es " + num2);


    }



}
