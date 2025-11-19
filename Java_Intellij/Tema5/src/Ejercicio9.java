public class Ejercicio9 {

    public static void main(String[] args) {

        int[] randoms = new int[10];
        int contador = 0;

        System.out.print("Array: ");
        for (int i = 0; i < randoms.length; i++) {

            randoms[i] = (int) (Math.random() * (10 - (-11) + 1) + (-11));
            System.out.print(randoms[i] + " ");

        }

        System.out.println(" ");
        for (int i = 0; i < randoms.length; i++) {

            for (int j = 0; j < randoms.length-1; j++) {

                if (randoms[i] == randoms[j+1]) {

                    contador++;
                    break;

                }

            }

        }

        System.out.println("Hay " + contador + " numeros que se repiten");

    }

}
