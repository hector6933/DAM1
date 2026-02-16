package Ejercicios1.Ejercicio8;

import java.util.Scanner;
import java.util.TreeMap;

public class Demo2 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        TreeMap<Character,Integer> listaLetras = new TreeMap<>();

        System.out.println("Introduce una frase");
        System.out.print("> ");
        String frase = leer.nextLine().replaceAll(" ","");

        for (Character c: frase.toCharArray()) {

            listaLetras.put(c, listaLetras.containsKey(c) ? listaLetras.get(c) + 1 : 1);

        }

        System.out.println(listaLetras);

        leer.close();

    }

}
