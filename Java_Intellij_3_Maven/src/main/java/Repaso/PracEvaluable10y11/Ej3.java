package Repaso.PracEvaluable10y11;

import java.util.HashMap;
import java.util.Scanner;

public class Ej3 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        HashMap<Character, Integer> mapa = new HashMap<>();

        System.out.println("Introduce una frase ");
        System.out.print("> ");
        String frase = leer.nextLine();

        if (!frase.isEmpty()) {

            for (Character e: frase.toCharArray()) {

                if (mapa.get(e) != null) {

                    System.out.println("El primer carácter que se repite es: " + e + " en la posición " + frase.indexOf(e));
                    return;

                }
                mapa.put(e,1);

            }

            System.out.println("No se repite ningún carácter !");

        } else {

            System.out.println("No hay frase");

        }


        leer.close();

    }

}
