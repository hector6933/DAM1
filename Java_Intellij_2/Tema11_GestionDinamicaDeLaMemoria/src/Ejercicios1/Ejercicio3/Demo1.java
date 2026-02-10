package Ejercicios1.Ejercicio3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Demo1 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        ArrayList<Integer> randoms = new ArrayList<>();

        Random random = new Random();

        int numero;

        for (int i = 0; i < 50; i++) {

            randoms.add(random.nextInt(0,100));

        }
        System.out.println(randoms);

        do {
            System.out.println("Introduce un número entre 0 y 99");
            try {

                numero = Integer.parseInt(leer.nextLine());
                if (numero < 0 || numero > 99) {

                    System.out.println("El número debe de estar entre 0 y 99 !!!");

                } else {

                    break;

                }

            } catch (NumberFormatException e) {

                System.out.println("Número inválido !!!");

            }

        } while (true);

        final int temp = numero;
        System.out.println("El número " + temp + " aparece " + randoms.stream().filter(a-> a == temp).count() + " veces");

        leer.close();

    }

}
