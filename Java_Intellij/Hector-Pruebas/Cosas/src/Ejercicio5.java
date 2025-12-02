import java.util.Scanner;
public class Ejercicio5 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        boolean correcto = false;
        int num1;
        int num2;
        do {
            System.out.println("Introduce un número entero:");
            System.out.print("> ");
            if (leer.hasNextInt()) {

                num1 = leer.nextInt();
                leer.nextLine();
                do {

                    System.out.println("Introduce otro número entero:");
                    System.out.print("> ");
                    if (leer.hasNextInt()) {

                        num2 = leer.nextInt();
                        leer.nextLine();

                        System.out.println("El mayor de los dos es: " + Math.max(num1,num2));
                        System.out.println("Y el menor: " + Math.min(num1,num2));
                        if (Math.max(num1,num2) % Math.min(num1,num2) == 0) {

                            System.out.println("El mayor es múltiplo del menor");

                        } else {

                            System.out.println("El mayor NO es múltiplo del menor");

                        }
                        correcto = true;

                    } else {

                        System.out.println("Número inválido !!!");
                        leer.nextLine();

                    }

                } while (!correcto);

            } else {

                System.out.println("Número inválido !!!");
                leer.nextLine();

            }

        } while (!correcto);

        leer.close();

    }

}
