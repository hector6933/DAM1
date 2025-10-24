public class Ejercicio10 {

    public static void main(String[] args) {

        String abc = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";

        int min = 0;
        int max = 26;

        int random = (int) (Math.random() * (max - min) + min);

        String letra = String.valueOf(abc.charAt(random));

        if (letra.equalsIgnoreCase("A") || letra.equalsIgnoreCase("E") || letra.equalsIgnoreCase("I") || letra.equalsIgnoreCase("o") || letra.equalsIgnoreCase("U")) {

            System.out.println("La letra random es " + letra + " y es vocal");

        } else {

            System.out.println("La letra random es " + letra + " y es consonante");

        }

    }

}
