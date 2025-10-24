import java.util.*;
public class Ejercicio5B {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        int min = 0;
        System.out.print("Dime el numero máximo para sacar un aleatorio desde 0: ");
        int max = leer.nextInt();
        int random = (int) (Math.random() * (max - min + 1) + min);
        // Esto se hace porque Math.random() nunca saca 1 entonces si math random da 0.999 y se mutiplica por 10 dará 9'999 osea 9

        System.out.println("");
        System.out.println("El número random es: " + random);
    }

}
