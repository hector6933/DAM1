public class Ejercicio7 {

    public static void main(String[] args) {

        int[] randoms = new int[10];

        for (int i = 0; i < randoms.length; i++) {

            randoms[i] = (int) (Math.random() * (10 - (-11) + 1) + (-11));

        }

        for (int todos : randoms) {

            System.out.print(todos + " | ");

        }
        System.out.println(" ");

        for (int i = 0; i < randoms.length; i++) {

            randoms[i] = Math.abs(randoms[i]);

        }

        for (int todos : randoms) {

            System.out.print(todos + " | ");

        }

    }

}
