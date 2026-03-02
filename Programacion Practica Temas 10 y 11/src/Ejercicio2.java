import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {

        // Me creo un Scanner para pedirle por teclado números al usuario
        Scanner leer = new Scanner(System.in);

        // Me creo una lista de enteros para almacenar los números que me introduzca el usuario
        ArrayList<Integer> numeros = new ArrayList<>();

        // Le pido 5 números al usuario comprobando que sean válidos
        do {

            System.out.println("Introduce un número entero ");
            System.out.print("> ");

            try {

                int numero = Integer.parseInt(leer.nextLine());
                numeros.add(numero);


            } catch (NumberFormatException e) {

                System.out.println("Número inválido !!!");

            }

        } while (numeros.size() != 5);

        // Por último compruebo que estén ordenados de mayor a menor y saco el resultado por pantalla
        boolean ordenados = true;

        // Hago numeros.size()-1 para no comprobar el último con el siguiente, que daría error
        for (int i = 0; i < numeros.size()-1; i++) {

            if ( !(numeros.get(i) < numeros.get(i+1)) ) {

                ordenados = false;
                break;

            }

        }

        if (ordenados) {

            System.out.println("Los números están ordenados de menor a mayor");

        } else {

            System.out.println("Los números NO están ordenados de menor a mayor !!!");

        }

        leer.close();

    }

}
