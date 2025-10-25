import java.util.Scanner;
public class Ejercicio16 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        boolean correcto;
        boolean salir = false;
        do {

            do {

                correcto = false;
                System.out.print("Introduce la cantidad en pesetas: ");
                if (leer.hasNextDouble()) {

                    if (leer.hasNextInt()) {

                        int pesetas = leer.nextInt();
                        leer.nextLine();
                        if (pesetas < 0 ) {

                            System.out.println("La cantidad ha de ser mayor que 0");

                        } else if (pesetas == 0) {

                            System.out.println("Saliendo...");
                            salir = true;

                        } else {

                            System.out.println(pesetas + " pesetas, son " + String.format("%.2f",(pesetas/166.386)) + "€");
                            correcto = true;

                        }

                    } else {

                        double pesetas = leer.nextDouble();
                        leer.nextLine();
                        if (pesetas < 0 ) {

                            System.out.println("La cantidad ha de ser mayor que 0");

                        } else if (pesetas == 0) {

                            System.out.println("Saliendo...");
                            salir = true;

                        } else {

                            System.out.println(pesetas + " pesetas, son " + String.format("%.2f",(pesetas/166.386)) + "€");
                            correcto = true;

                        }

                    }

                } else {

                    System.out.println("ERROR /// Introduce un número real porvafor");
                    leer.nextLine();

                }

            } while (!correcto);


        } while (!salir);

    }

}
