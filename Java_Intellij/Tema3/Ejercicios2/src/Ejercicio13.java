import java.util.Scanner;
public class Ejercicio13 {

    public static void main(String[] args) {
        // Se que se hace de una manera pero no me la sé, asi que lo hago como quiero

        Scanner leer = new Scanner(System.in);

        boolean correcto = false;
        int numero;
        String cifras;

        do {

            System.out.print("Introduce un número entero positivo: ");
            if (leer.hasNextInt()) {

                numero = leer.nextInt();
                leer.nextLine();
                if (numero < 0) {

                    System.out.println("Tiene que ser un número entero positivo !!!");

                } else {

                    cifras = Integer.toString(numero);
                    System.out.println("El número tiene " + cifras.length() + " cifras");
                    correcto = true;

                }

            } else {

                System.out.println("Eso NO es un número entero !!!");
                leer.nextLine();

            }

        } while (!correcto);



    }

}
