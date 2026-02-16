package Probatinas;

import java.util.ArrayList;
import java.util.Random;

public class QuickSort {
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


    }

}
