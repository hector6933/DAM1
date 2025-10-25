import java.util.Scanner;
public class Ejercicio17 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        double facturacion;
        double totalAnual = 0;
        double max = 0;
        double min = 999999999;
        for (int i = 0; i < 12; i++) {

            System.out.println("Introduce la facturación del mes " + (i+1));
            if (leer.hasNextDouble()) {

                facturacion = leer.nextDouble();
                leer.nextLine();
                totalAnual = (totalAnual + facturacion);
                if (totalAnual > max) {
                    
                    max = totalAnual;

                }

            }
        }
        System.out.println("La media de la facturación anual es de " + (totalAnual / 12));

    }

}
