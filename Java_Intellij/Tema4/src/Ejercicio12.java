public class Ejercicio12 {

    public static int fibonnacci(int numero) {

        if (numero == 0) {

            return 0;

        } else if (numero == 1) {

            return 1;

        } else {

            return fibonnacci(numero-1) + fibonnacci(numero-2);

        }

    }

    public static void main(String[] args) {

        int num = 9;
        System.out.println("La posición " + num + " de fibonacci es: " + fibonnacci(num));

    }

}
