import java.util.Scanner;
public class Ejercicio29 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        boolean correcto = false;
        int altura = 0;
        int anchura = 0;
        do {

            System.out.print("Dime la altura: ");
            if (leer.hasNextInt()) {

                altura = leer.nextInt();
                leer.nextLine();
                if (altura <= 0) {

                    System.out.println("Por favor, introduce un número entero positivo válido y mayor que 0");

                } else {

                    do {

                        System.out.print("Dime la anchura: ");
                        if (leer.hasNextInt()) {

                            anchura = leer.nextInt();
                            leer.nextLine();
                            if (anchura <= 0) {

                                System.out.println("Por favor, introduce un número entero positivo válido y mayor que 0");

                            } else {

                                correcto = true;

                            }


                        } else {

                            System.out.println("Por favor, introduce un número entero válido");
                            leer.nextLine();

                        }

                    } while (!correcto);

                }

            } else {

                System.out.println("Por favor, introduce un número entero válido");
                leer.nextLine();

            }

        } while (!correcto);
        for (int i = 0; i <= altura; i++) {

            for (int j = 0; j <= anchura; j++) {

                if ((i == 0 || i == altura) || (j == 0 || j == anchura)) {

                    System.out.print("*");

                } else {

                    System.out.print(" ");

                }

            }
            System.out.println(" ");

        }

    }

}
