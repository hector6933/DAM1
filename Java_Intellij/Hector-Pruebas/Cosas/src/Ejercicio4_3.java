import java.util.Scanner;
public class Ejercicio4_3 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        boolean correcto = false;

        int num1;
        int num2;

        do {

            System.out.println("Introduce un número entero positivo como rango mínimo");
            System.out.print("> ");
            if (leer.hasNextInt()) {

                num1 = leer.nextInt();
                leer.nextLine();
                if (num1 < 0) {

                    System.out.println("El número TIENE que ser positivo !!!");

                } else {

                    do {
                        System.out.println("Introduce otro número entero positivo como rango máximo");
                        System.out.print("> ");

                        if (leer.hasNextInt()) {

                            num2 = leer.nextInt();
                            leer.nextLine();

                            if (num1 > num2) {

                                System.out.println("El número debe de ser mayor al introducido anteriormente !!!");

                            } else {

                                correcto = true;
                                System.out.println("Randoms:");
                                for (int i = 0; i < 1000; i++) {

                                    System.out.println((int) (Math.random() * (num2 - num1 + 1) + num1));

                                }

                            }

                        } else {

                            System.out.println("Número inválido !!!");
                            leer.nextLine();

                        }
                    } while (!correcto);

                }

            } else {

                System.out.println("Número inválido !!!");
                leer.nextLine();

            }

        } while (!correcto);


        leer.close();


    }

}
