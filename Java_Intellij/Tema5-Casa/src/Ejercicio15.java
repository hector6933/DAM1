public class Ejercicio15 {

    public static String reverseCadena(String cadena) {

        StringBuilder superCadena = new StringBuilder(cadena);

        return superCadena.reverse().toString();

    }


    public static void main() {

        String miCadena = "Hola pascual !";

        System.out.println(reverseCadena(miCadena));

    }

}
