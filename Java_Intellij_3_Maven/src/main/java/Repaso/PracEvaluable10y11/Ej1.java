package Repaso.PracEvaluable10y11;

import java.util.ArrayList;
import java.util.Random;

public class Ej1 {

    public static void main(String[] args) {

        Random random = new Random();

        ArrayList<Integer> randoms = new ArrayList<>();

        do {

            randoms.add(random.nextInt(1,50));

        } while (randoms.size() != 20);

        for (Integer e: randoms) {

            if (randoms.stream().filter(a -> a.equals(e)).count() == 1) {

                System.out.println("El primer número que no se repite es el " + e);
                return;

            }

        }

        System.out.println("Todos los números se repiten !");



    }

}
