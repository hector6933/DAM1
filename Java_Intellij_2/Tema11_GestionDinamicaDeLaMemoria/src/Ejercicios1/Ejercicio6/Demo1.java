package Ejercicios1.Ejercicio6;

import java.util.ArrayList;
import java.util.Random;

public class Demo1 {

    public static void main(String[] args) {

        ArrayList<Integer> randoms = new ArrayList<>();

        Random random = new Random();

        do {

            int temp = random.nextInt(0,100);
            if (!randoms.contains(temp)) {

                randoms.add(temp);

            }

        } while (randoms.size() != 100);

        System.out.println(randoms);

    }

}
