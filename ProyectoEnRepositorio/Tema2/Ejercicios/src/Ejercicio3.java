import java.util.Scanner;
public class Ejercicio3 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        // MUY IMPORTANTE SABER:
        /*System.out.print("Dime un letra: ");
        String caracter = leer.next();

        int letra = caracter.charAt(0);

        System.out.print("Ese numero en ASCII es: " + letra);*/


        System.out.print("Dime una numerin: ");
        int letrita = leer.nextInt();

        char ascii = (char) letrita;

        System.out.println("Ese número en ascii es: " + ascii);

        if (letrita == 65 || letrita == 69 || letrita == 73 || letrita == 79 || letrita == 85 ) {

            System.out.println("Es una vocal en mayúsculas");

        } else if (letrita == 97 || letrita == 101 || letrita == 106 || letrita == 111 || letrita == 117) {

            System.out.println("Es una vocal en minusculas");

        } else if ((letrita >= 65 && letrita <= 90)) {

            System.out.println("La letra está dentro del alfabeto está en mayúscula y es consonante");

        } else if (letrita >= 97 && letrita <= 122) {

            System.out.println("La letra está dentro del alfabeto está en minúscula y es consonante");

        } else {

            System.out.println("Que cojones has puesto");

        }
    }

}
