import java.util.Scanner;

public class Ejercicio9 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.print("Dime un número: ");
        int num1 = leer.nextInt();

        System.out.print("Dime otro número: ");
        int num2 = leer.nextInt();

        System.out.println(num1 + " elevado a " + num2 + " es: " + String.format("%.0f",Math.pow(num1,num2)));
    }

}
