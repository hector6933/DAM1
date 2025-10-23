import java.util.Scanner;
public class ascii {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        int numerin;
        String caracter;

        System.out.println("Dime un caracter y te digo su numero en ascii");
        caracter = leer.next();

        numerin = caracter.charAt(0);

        System.out.println("El número es " + numerin);

        System.out.println("Dime un numero y te digo su caracter");

        char letra = (char) leer.nextInt();

        System.out.println("La letra es " + letra);

    }

}
