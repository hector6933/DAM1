import java.util.Scanner;
public class Ejercicio1 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        int min = 1;
        int max = 100;
        int guess = 0;
        int intentos = 1;
        boolean salir = false;
        String opcion;
        boolean correcto = false;
        int random = (int) (Math.random() * (max - min) + min);

        do {

            // System.out.println("Como testeo, el número random es " + random);

            do {

                System.out.print("Intenta adivinar el número entre 1 y 100: ");
                if (!leer.hasNextInt()) {

                    System.out.println("Por favor introduce un número entero válido");
                    leer.nextLine();

                } else {

                    guess = leer.nextInt();
                    leer.nextLine();
                    if (guess < 0 || guess > 100) {

                        System.out.println("El número debe de estar comprendido entre 0 y 100");

                    } else {

                        correcto = true;

                    }

                }
            } while (!correcto);

            correcto = false;

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
