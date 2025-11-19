public class Ejercicio8 {

    public static void main(String[] args) {

        int[] randoms1 = new int[10];
        int[] randoms2 = new int[10];
        int[] suma = new int[10];

        System.out.print("Array 1: ");
        for (int i = 0; i < randoms1.length; i++) {

            randoms1[i] = (int) (Math.random() * (10 -(-11) + 1) + -(11));
            System.out.print(randoms1[i] + " ");


        }

        System.out.println(" ");

        System.out.print("Array 2: ");

        for (int i = 0; i < randoms2.length; i++) {

            randoms2[i] = (int) (Math.random() * (10 -(-11) + 1) + -(11));
            System.out.print(randoms2[i] + " ");

        }

        System.out.println(" ");

        System.out.print("Array 1 + Array 2: ");
        for (int i = 0; i < suma.length; i++) {

            suma[i] = randoms1[i] + randoms2[i];
            System.out.print(suma[i] + " ");

        }

    }

}
