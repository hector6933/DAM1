import java.util.Scanner;
public class Ejercicio17 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        boolean correcto;
        double facturacion;
        double totalAnual = 0;
        double max = 0;
        double min = 999999999;
        int mesMax = 0;
        int mesMin = 0;
        for (int i = 0; i < 12; i++) {

            do {
                correcto = false;
                System.out.print("Introduce la facturación del mes " + (i+1) + ": ");
                if (leer.hasNextDouble()) {

                    facturacion = leer.nextDouble();
                    leer.nextLine();
                    totalAnual = (totalAnual + facturacion);
                    if (facturacion > max) {

                        max = facturacion;
                        mesMax = i+1;

                    }
                    if (facturacion < min) {

                        min = facturacion;
                        mesMin = i+1;

                    }
                    correcto = true;

                } else {

                    System.out.println("Tiene que ser un número real !!!");
                    leer.nextLine();

                }

            } while (!correcto);

        }
        leer.close();
        System.out.println("El total anual de facturación es de " + totalAnual);
        System.out.println("La media de la facturación anual es de " + (totalAnual / 12));
        System.out.println("El mes con más facturación ha sido " + mesMax + " con " + max);
        System.out.println("El mes con menos facturación ha sido " + mesMin + " con " + min);

    }

}
