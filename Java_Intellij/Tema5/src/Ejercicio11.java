public class Ejercicio11 {

    public static void main(String[] args) {

        int[] randoms = new int[10];
        int numeroMeter;

        int contador = 0;
        boolean esta = false;
        
        for (int i = 0; i < randoms.length; i++) {

            numeroMeter = (int) (Math.random() * (10 - (-11) + 1) + (-11));
            System.out.println("Número random de la iteración " + i + ": " + numeroMeter);
            for (int j = 0; j < randoms.length; j++) {
                esta = false;
                if (numeroMeter == randoms[j]) {

                    System.out.println("El número está en el array");
                    esta = true;

                }

            }
            if (!esta) {

                randoms[i] = numeroMeter;

            }

        }
        System.out.println("Randoms que NO se repiten:");
        for (int numeros : randoms) {

            System.out.print(numeros + " ");

        }

    }

}
