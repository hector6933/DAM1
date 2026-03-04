import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {

        // Me creo el mapara de los carácteres de la fase
        HashMap<Character,Integer> caracteres = new HashMap<>();

        // Me creo el escáner para leer por teclado la frase que me introduzca el usuario
        Scanner leer = new Scanner(System.in);

        System.out.println("Introduce una frase ");
        System.out.print("> ");
        String frase = leer.nextLine();

        // Introduzco en el mapa el carácter y el número de veces que se repite
        for (Character c: frase.toCharArray()) {

            if (caracteres.containsKey(c)) {

                System.out.println("El primer carácter que se repite es: " + c + " con la posición " + frase.indexOf(c));
                return;
            }

            caracteres.put(c, 1);

        }

        System.out.println("No hay ningún carácter que se repita !!!");

        // En caso de que el número de veces que se repita el carácter correspondiente lo sacaré por pantalla y se acabará el programa
//        for (Character c : frase.toCharArray()) {
//
//            if (caracteres.get(c) > 1) {
//
//                System.out.println("El primer carácter que se repite es: " + c + " con la posición " + frase.indexOf(c));
//                return;
//
//            }
//
//        }
//
//        // En caso de que no se repita ningún carácter lo indico por pantalla
//        System.out.println("No se repite ningún carácter !!!");

        leer.close();

    }

}
