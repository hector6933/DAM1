package Repaso.PracEvaluable10y11;

import java.awt.font.FontRenderContext;
import java.util.ArrayList;
import java.util.Scanner;

public class Ej2 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        ArrayList<Integer> numeros = new ArrayList<>();

        do {

            System.out.println("Introduce un número entero ");
            System.out.print("> ");

            try {

                int numero = Integer.parseInt(leer.nextLine());

                numeros.add(numero);

            } catch (NumberFormatException e) {

                System.out.println("Introduce un número entero válido !!!");

            }

        } while (numeros.size() != 5);

        for (int i = 0; i < numeros.size()-1; i++) {

            if ( !(numeros.get(i) < numeros.get(i+1)) ) {

                System.out.println("Los números NO están ordenados de menor a mayor !!!");
                return;

            }

        }

        System.out.println("Los números están ordenados de menor a mayor");


        leer.close();

    }

}
