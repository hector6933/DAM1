import java.util.Scanner;
public class Clase1 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.print("Dime un numero: ");
        int num1 = leer.nextInt();
        System.out.print("Dime otro numero: ");
        int num2 = leer.nextInt();

        int opcion;

        do {
            System.out.println("¿Que quieres hacer?");
            System.out.println("1 - Sumar");
            System.out.println("2 - Restar");
            System.out.println("3 - Multiplicar");
            System.out.println("0 - Salir");

            opcion = leer.nextInt();
            switch (opcion) {

                case 1:
                    System.out.println("La suma es de: " + (num1 + num2));
                    break;
                case 2:
                    System.out.println("La resta es de: " + (num1 - num2));
                    break;
                case 3:
                    System.out.println("La multiplicacion es de: " +(num1 * num2));
                    break;
                case 0:
                    System.out.println("Hasta pronto !!!");
                default:
                    System.out.println("Escoge una opcion valida");
            }
        } while (opcion != 0);
    }

}
