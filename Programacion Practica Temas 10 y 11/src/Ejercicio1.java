import java.util.ArrayList;
import java.util.Random;

public class Ejercicio1 {

    public static void main(String[] args) {

        // Uso la clase random para generar los números aleatorios
        Random random = new Random();

        ArrayList<Integer> randoms = new ArrayList<>();

        // Genero 20 números aleatorios entre 0 y 49
        do {

            randoms.add(random.nextInt(0,50));

        } while (randoms.size() != 20);

        System.out.println("Lista de todos los números: ");
        System.out.println(randoms);

        // Compruebo mediante un for each anidado si el número correspondiente se repite o no
        for (Integer e: randoms) {

            int cont = 0;
            for (Integer i: randoms) {

                if (e.equals(i)) {

                    cont++;

                }

            }

            // En caso de que el contador se sume una sola vez, osea que NO se repite lo muestro por pantalla y salgo
            if (cont == 1) {

                System.out.println("El primer número que NO se repite es el: " + e);
                break;

            }

        }


    }

}
