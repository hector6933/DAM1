import java.util.Scanner;
public class comprobarLetraABC {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.println("Dime un carácter y te digo si está en el abecedario");
        int letra = (int) leer.next().charAt(0);

        if ((letra >= 'a' && letra <= 'z') || (letra >= 'A' && letra <= 'Z') ) {

            System.out.println("La letra está en el abecedario");

        } else {

            System.out.println("La letra NO está en el abecedario");

        }




    }

}
