package Probatinas;

import java.util.ArrayList;
import java.util.Random;

public class InsertionSortMenorAMayor {

    public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<>();

        Random random = new Random();
        int cantidad = 100;

        do {

            int temp = random.nextInt(0,1001);

            if (!numeros.contains(temp)) {

                numeros.add(temp);

            }

        } while (numeros.size() != cantidad);

        System.out.println("Lista de números random: ");
        System.out.println(numeros);


        // Ordenar de menor a mayor por Insertion Sort
        for (int i = 0; i < numeros.size(); i++) {

            // Me creo una variable temporal ya que tengo que iterarla, si lo hago con i la iteración actual se pierde
            int j = i;

            // Compruebo que j sea mayor que 0 ya que tengo que buscar en (j-1), en caso de ser 0 da error
            // Intercambio los números en caso de que el número a la izquierda sea mayor que el de la derecha
            while (j > 0 && numeros.get(j-1) > numeros.get(j)) {

                int temp = numeros.get(j-1);
                numeros.set(j-1,numeros.get(j));
                numeros.set(j,temp);

                // Resto cada vez la j porque lo quiero llevar hacia la izquierda
                j--;

            }

        }

        System.out.println("Lista ordenada de menor a mayor:");
        System.out.println(numeros);

    }

}
