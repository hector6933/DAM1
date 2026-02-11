package Ejercicios1.Ejercicio5;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo1 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        ArrayList<String> lista = new ArrayList<>();

        do {

            System.out.println("Introduce palabras (S - Salir):");
            System.out.print("> ");
            String palabra = leer.nextLine();
            if (!palabra.equalsIgnoreCase("s")) {

                lista.add(palabra);

            } else {

                break;

            }

        } while (true);

        System.out.println("Lista:");
        System.out.println(lista);

        do {
            System.out.println("Introduce la palabra que quieres BORRAR: ");
            System.out.print("> ");
            String pal1 = leer.nextLine();

            if (!lista.contains(pal1)) {

                System.out.println("Esa palabra NO está en la lista !!!");

            } else {

                lista.remove(pal1);
                break;

            }
        } while (true);
        System.out.println("Lista:");
        System.out.println(lista);

    }

}
