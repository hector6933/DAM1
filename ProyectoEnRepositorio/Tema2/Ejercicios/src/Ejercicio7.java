import java.util.Scanner;
public class Ejercicio7 {

    public static void main(String[] args) {

            Scanner leer = new Scanner(System.in);

            System.out.print("Dime un número: ");
            int num1 = leer.nextInt();

            System.out.print("Dime otro número: ");
            int num2 = leer.nextInt();

            System.out.println("El producto es: " +  Math.multiplyExact(num1, num2));
    }

}
