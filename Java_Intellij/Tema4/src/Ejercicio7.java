import java.util.Scanner;
public class Ejercicio7 {


    public static String calificacion(double nota) {

        if (nota >= 9) {

            return "Sobresaliente";

        } else if (nota >= 7) {

            return "Notable";

        } else if (nota >= 5) {

            return "Aprobado";

        } else {

            return "Suspenso";

        }

    }

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        boolean correcto = false;

        double nota = 0;
        do {
            System.out.println("Introduce una nota: ");
            System.out.print("> ");
            try {

                nota = Double.parseDouble(leer.nextLine());
                correcto = true;

            } catch (NumberFormatException e) {

                System.out.println("Número inválido !!!");

            }

            if (nota < 0 || nota > 10) {

                System.out.println("La nota debe de estar comprendida entre 0 y 10");
                correcto = false;

            }

        } while (!correcto);

        System.out.println("Calificacion: " + calificacion(nota));

    }

}
