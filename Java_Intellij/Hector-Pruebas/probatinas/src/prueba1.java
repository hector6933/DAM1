import java.util.Scanner;
public class prueba1 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        String nombre = "Hector";
        int letra;

        System.out.println("Dime un caracter");
        letra = leer.next().charAt(0);
        if ((letra >= 'a' && letra <= 'z') || (letra >= 'A' && letra <= 'A')) {

            System.out.println("El caracter está en el abecedario");

        } else {

            System.out.println("El caracter NO está en el abecedario");

        }

    }

}
