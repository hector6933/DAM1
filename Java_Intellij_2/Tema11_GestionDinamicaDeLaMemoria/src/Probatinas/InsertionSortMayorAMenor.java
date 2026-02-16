package Probatinas;

import java.util.ArrayList;
import java.util.Random;

public class InsertionSortMayorAMenor {

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

        for (int i = 0; i < numeros.size(); i++) {

            int j = i;
            while (j > 0 && numeros.get(j-1) < numeros.get(j)) {

                int temp = numeros.get(j-1);
                numeros.set(j-1,numeros.get(j));
                numeros.set(j,temp);

                j--;

            }

        }

        System.out.println("Lista de números ordenada de mayor a menor: ");
        System.out.println(numeros);

    }

}
