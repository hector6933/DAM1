import java.util.Scanner;

public class Ejercicio11 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        boolean tieneGaraje = false;
        boolean meInteresa;

        System.out.print("Cual es el precio de la vivienda sin decimales: ");
        int precio = leer.nextInt();

        System.out.print("Cual es la superficie en metros cuadrados: ");
        int superficie = leer.nextInt();

        System.out.println("¿Tiene garaje?(S/N)");
        String respuesta = leer.next();

        if (respuesta.equalsIgnoreCase("S")) {

            tieneGaraje = true;

        } else if (respuesta.equalsIgnoreCase("N")) {

            tieneGaraje = false;

        } else {

            System.out.println("Respuesta inválida");

        }

        if (precio < 150000 && superficie > 80 && tieneGaraje) {

            meInteresa = true;

        } else {

            meInteresa = false;

        }

        System.out.println("Me interesa: " + meInteresa);


    }

}
