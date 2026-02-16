package Ejercicios1.Ejercicio8;

import java.util.Scanner;
import java.util.TreeMap;

public class Demo1 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.println("Introduce una frase");
        System.out.print("> ");
        String frase = leer.nextLine();

        frase = frase.replaceAll("[^A-za-z]+","");

        TreeMap<Character,Integer> letras = new TreeMap<>();

        for (char i: frase.toCharArray()) {

            letras.put(i,letras.containsKey(i) ? letras.get(i) + 1 : 1);

        }

        System.out.println(letras);

        leer.close();

    }

}
