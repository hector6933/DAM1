import java.util.Scanner;
public class Ejercicio4 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        System.out.print("Dime un numero: ");
        int num = leer.nextInt();
        System.out.println("La raíz cuadrada del número es " + Math.sqrt(num));


    }

}
