public class Ejercicio10 {

    public static void main(String[] args) {

        int[] randoms = new int[10];
        int contador;
        for (int i = 0; i < randoms.length; i++) {

            randoms[i] = (int) (Math.random() * (10 - (-11) + 1) + (-11));

        }

        System.out.println("Array:");
        for (int numeros : randoms) {

            System.out.print(numeros + " ");

        }

        System.out.println();
        for (int i = -10; i <= 10; i++) {

            contador = 0;
            for (int random : randoms) {

                if (i == random) {

                    contador++;

                }

            }

            if (contador == 1) {

                System.out.println("El número " + i + " NO se repite.");

            }

        }

    }

}
