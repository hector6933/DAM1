public class Ejercicio10Otraforma {

    public static void main(String[] args) {

        int min = 65;
        int max = 90;

        int random = (int) (Math.random() * (max - min) + min);

        char ascii = (char) random;

        String letra = String.valueOf(ascii);

        if (letra.equalsIgnoreCase("A") || letra.equalsIgnoreCase("E") || letra.equalsIgnoreCase("I") || letra.equalsIgnoreCase("o") || letra.equalsIgnoreCase("U")) {

            System.out.println("La letra random es " + letra + " y es vocal");

        } else {

            System.out.println("La letra random es " + letra + " y es consonante");

        }

    }

}
