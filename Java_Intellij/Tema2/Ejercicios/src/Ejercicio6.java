import java.util.Scanner;

public class Ejercicio6 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.print("Dime un número: ");
        int num1 = leer.nextInt();

        System.out.print("Dime otro número: ");
        int num2 = leer.nextInt();

        int mayor = Math.max(num1, num2);
        int menor = Math.min(num1, num2);

        if (mayor % menor == 0 ) {

            System.out.println("El número mayor " + mayor + " es múltiplo del menor " + menor);

        } else {

            System.out.println("El número mayor " + mayor + " NO es múltiplo del menor " + menor);

        }
    }

}
