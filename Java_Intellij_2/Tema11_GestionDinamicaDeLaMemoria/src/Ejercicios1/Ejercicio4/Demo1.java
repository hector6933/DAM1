package Ejercicios1.Ejercicio4;

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

        System.out.println("Introduce la palabra que quieres sustituir: ");
        System.out.print("> ");
        String pal1 = leer.nextLine();

        System.out.println("Introduce la palabra a sustituir: ");
        System.out.print("> ");
        String pal2 = leer.nextLine();

//        String pal2temp = lista.get() ;
//        lista.set(pal2Pos,pal1);
//
//        leer.close();
    }

}
