import java.util.Scanner;
public class Ejercicio1 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        int min = 1;
        int max = 100;
        int guess;
        int intentos = 1;
        boolean salir = false;
        String opcion;
        boolean correcto = false;
        int random = (int) (Math.random() * (max - min) + min);

        do {

            // System.out.println("Como testeo, el número random es " + random);

            System.out.print("Intenta adivinar el número entre 1 y 100: ");
            guess = leer.nextInt();

            if (guess > random) {

                System.out.println("El número random es menor");
                intentos = intentos + 1;

            } else if (guess < random) {

                System.out.println("El número random es mayor");
                intentos = intentos + 1;

            } else {

                System.out.println("Enhourabuena, has acertado !!!");
                System.out.println("Lo has realizado en " + intentos + " intentos");
                if (intentos <= 5) {

                    System.out.println("¡Increíble!");

                } else if (intentos <= 10) {

                    System.out.println("¡Muy bien!");

                } else {

                    System.out.println("Sigue practicando...");

                }

                do {

                    System.out.println("¿Quieres jugar otra vez? (S/N)");
                    opcion = String.valueOf(leer.next().charAt(0));

                    if (opcion.equalsIgnoreCase("N")) {

                        salir = true;
                        System.out.println("Saliendo...");
                        correcto = true;

                    } else if (opcion.equalsIgnoreCase("S")) {

                        System.out.println("-------------------------------------------");
                        random = (int) (Math.random() * (max - min) + min);
                        correcto = true;
                        intentos = 1;

                    } else {

                        System.out.println("Opción inválida, inténtelo de nuevo");

                    }

                } while (!correcto);


            }

        } while (!salir);

    }


}
