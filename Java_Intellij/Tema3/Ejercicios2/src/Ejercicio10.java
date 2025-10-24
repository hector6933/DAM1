import java.util.Scanner;
public class Ejercicio10 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        boolean correcto = false;
        int num1;
        int num2;
        int total = 0;
        do {

            System.out.print("Dime un número entero: ");
            if (leer.hasNextInt()) {

                num1 = leer.nextInt();
                leer.nextLine();
                do {

                    System.out.print("Dime otro número entero: ");
                    if (leer.hasNextInt()) {

                        num2 = leer.nextInt();
                        leer.nextLine();
                        correcto = true;
                        for (int i = 0; i < num2; i++) {

                            total = num1 + total;

                        }
                        System.out.println(num1 + " * " + num2 + " = " + total);

                    } else {

                        System.out.println("Eso NO es un número entero válido");
                        leer.nextLine();

                    }

                } while (!correcto);

            } else {

                System.out.println("Eso NO es un número entero válido");
                leer.nextLine();

            }

        } while (!correcto);


    }

}
