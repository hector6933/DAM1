public class Ejercicio6 {

    public static void main(String[] args) {

        int[] randoms = new int[10];
        int contador = 0;

        for (int i = 0; i < randoms.length; i++) {

            randoms[i] = (int) (Math.random() * (10 - (-11) + 1) + (-11));

        }

        for (int i = 0; i < randoms.length; i++) {

            System.out.print(randoms[i] + " ");
            if (randoms[i] < 0 ) {

                contador++;

            }

        }
        System.out.println("\nHay " + contador + " números negativos");


    }

}
