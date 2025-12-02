import java.awt.font.FontRenderContext;

public class Ejercicio11 {

    public static void main(String[] args) {

        int[] randoms = new int[100];
        int numeroMeter;

        boolean esta = false;
        int contador = 0;

        while (contador < randoms.length) {

            esta = false;
            numeroMeter = (int) (Math.random() * (10 - (-11) + 1) + (-11));

            for (int i = 0; i < randoms.length; i++) {

                if (numeroMeter == randoms[i]) {

                    esta = true;
                    break;

                }

            }

            if (!esta) {

                randoms[contador] = numeroMeter;
                contador++;

            }

        }

        System.out.println("Randoms que NO se repiten:");
        for (int numeros : randoms) {

            System.out.print(numeros + " ");

        }

    }

}
