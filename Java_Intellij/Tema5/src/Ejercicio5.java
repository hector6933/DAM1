import java.util.Scanner;
public class Ejercicio5 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        int[] randoms = new int[10];
        int pos = 0;
        boolean esta;
        boolean correcto;

        for (int i = 0; i < randoms.length; i++) {

            randoms[i] = (int) (Math.random() * 100);

        }

        System.out.println("---------------------------");
        System.out.println("ARRAY:");
        for (int a : randoms) {

            System.out.println(a);

        }
        System.out.println("---------------------------");

        do {
            correcto = false;
            System.out.println("Introduce un número entero y te digo si está en el array (Numero negativo para salir)");
            System.out.print("> ");
            try {

                pos = Integer.parseInt(leer.nextLine());
                correcto = true;
                if (pos >= 0) {

                    esta = false;

                    for (int random : randoms) {

                        if (pos == random) {

                            esta = true;
                            break;

                        }

                    }
                    if (esta) {

                        System.out.println("El número se encuentra en el Array");

                    } else {

                        System.out.println("El número NO se encuentra en el Array !!!");

                    }

                } else {

                    System.out.println("Saliendo...");

                }

            } catch (NumberFormatException e) {

                System.out.println("Eso NO es un número entero válido");

            }

        } while (pos >= 0 || !correcto);

    }

}
