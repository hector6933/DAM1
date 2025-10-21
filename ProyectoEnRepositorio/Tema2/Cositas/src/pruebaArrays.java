import java.util.Scanner;
// Probando Arrays
// Programa protegido contra:
//      - Usuario tonto
//      - Profesor cabrón
public class pruebaArrays {

    static Scanner leer = new Scanner(System.in);

    public static void rellenarArrayInt(int[] Array, int size) {

        boolean correcto;
        for (int i = 0; i < size; i++) {

            do {

                correcto = false;
                System.out.print("Dime un número entero para la posición " + (i + 1) + ": ");
                if (leer.hasNextInt()) {

                    Array[i] = leer.nextInt();
                    leer.nextLine();
                    correcto = true;

                } else {

                    System.out.println("Eso NO es un entero");
                    leer.nextLine();

                }

            } while (!correcto);

        }

    }

    public static void recorrerArrayInt(int Array[], int size) {

        System.out.println("-----------------------------------------");
        System.out.println("Valores de las posiciones del iterador:");
        for (int i = 0; i < size; i++) {

            System.out.println((i + 1) + " = " + Array[i]);

        }

    }


    public static void main(String[] args) {

        int[] numeros = new int[10];
        int longitud = 10;

        rellenarArrayInt(numeros, longitud);

        recorrerArrayInt(numeros, longitud);


    }


}
