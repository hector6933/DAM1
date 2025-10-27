import java.util.Scanner;
public class Ejercicio33 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        boolean correcto = false;
        boolean salir = false;
        int numero = 0;
        do {
            System.out.print("Introduce un número entero positivo: ");
            if (leer.hasNextInt()) {

                numero = leer.nextInt();
                leer.nextLine();
                if (numero <= 0) {

                    System.out.println("El número debe de ser mayor que 0");

                } else {

                    correcto = true;

                }

            } else {

                System.out.println("Eso NO es un número entero válido");
                leer.nextLine();

            }

        } while (!correcto);

        do {
            
            if (numero % 2 == 0) {

                System.out.print(numero + " | " + 2);
                System.out.println(" ");
                numero = numero / 2;
                
            } else if (numero % 3 == 0) {

                System.out.print(numero + " | " + 3);
                System.out.println(" ");
                numero = numero / 3;
                
            } else {

                System.out.print(numero + " | " + 1);
                System.out.println(" ");
                salir = true;
                
            }

        } while (!salir);

    }

}
