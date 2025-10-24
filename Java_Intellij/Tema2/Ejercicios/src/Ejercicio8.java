import java.util.Scanner;
public class Ejercicio8 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.print("Dime un número: ");
        int num1 = leer.nextInt();

        System.out.print("Dime otro número: ");
        int num2 = leer.nextInt();
        double resultado = (double) num1/num2;

        System.out.println(String.format("%.3f",resultado));
    }

}
