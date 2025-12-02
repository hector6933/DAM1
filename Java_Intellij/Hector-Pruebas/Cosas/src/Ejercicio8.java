import java.util.Scanner;
public class Ejercicio8 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        boolean correcto = false;
        double num1;
        double num2;

        do {

            System.out.println("Introduce el dividendo (debe ser entero): ");
            System.out.print("> ");
            if (leer.hasNextDouble()) {

                num1 = leer.nextDouble();
                leer.nextLine();

                do {

                    System.out.println("Introduce el divisor (debe ser entero):");
                    System.out.print("> ");
                    if (leer.hasNextDouble()) {

                        num2 = leer.nextDouble();
                        leer.nextLine();

                        if (num2 == 0) {

                            System.out.println("El divisor NO puede ser 0");

                        } else {

                            System.out.println("El cociente de la división entre esos dos números es: " + String.format("%.3f",num1/num2) );

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
