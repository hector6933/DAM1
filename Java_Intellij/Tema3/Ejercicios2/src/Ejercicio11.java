import java.util.Scanner;
public class Ejercicio11 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        boolean correcto = false;
        int num1;
        int num2;
        int contador = 0;
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
                        do {

                            if (num1 > 1) {

                                num1 = num1 - num2;
                                contador +=1;

                            } else {

                                correcto = true;
                                System.out.println("La división es " + contador);

                            }
                        } while (!correcto);

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
        leer.close();

    }

}
