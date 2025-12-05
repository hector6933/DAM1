public class Ejercicio16 {

    public static int darVueltaInt(int num) {

        StringBuilder darVuelta = new StringBuilder(String.valueOf(num));

        if (num > 0) {

            return Integer.parseInt(darVuelta.reverse().toString());

        } else {

            darVuelta.delete(0,1); // Elimino el signo, ya que el numero quedaria con el signo al final del numero, p.ej -12 --> 12-
            return -Integer.parseInt(darVuelta.reverse().toString());

        }

    }

    public static void main() {

        int numero1 = -1234;
        int numero2 = 1234;

        System.out.println(darVueltaInt(numero1));
        System.out.println(darVueltaInt(numero2));

    }

}
