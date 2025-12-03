import java.util.Scanner;
import java.util.ArrayList;

public class TicketDemo {

    public static void main() {

        Scanner leer = new Scanner(System.in);

        ArrayList<Ticket> producto = new ArrayList<>();

        boolean salir = false;
        boolean correcto = false;
        String nombre;
        int unidades = 0;
        double precio = 0;
        double tasaIva = 0;
        double totalSinIva = 0;
        double ivaTotal = 0;
        double total = 0;

        while (!salir) {

            System.out.println("Introduce el nombre del artículo:");
            System.out.print("> ");
            nombre = leer.next();
            leer.nextLine();

            do {

                System.out.println("Introduce las unidades del artículo: ");
                System.out.print("> ");
                try {

                    unidades = Integer.parseInt(leer.nextLine());
                    if (unidades < 0) {

                        System.out.println("La cantidad NO puede ser negativa !!!");

                    } else {

                        correcto = true;

                    }

                } catch (NumberFormatException e) {

                    System.out.println("Cantidad inválida !!!");

                }

            } while (!correcto);

            correcto = false;

            do {

                System.out.println("Introduce el precio:");
                System.out.print("> ");
                try {

                    precio = Double.parseDouble(leer.nextLine());
                    if (precio < 0) {

                        System.out.println("El precio NO puede ser negativo !!!");

                    } else {

                        correcto = true;

                    }

                } catch (NumberFormatException e) {

                    System.out.println("Precio inválido !!!");

                }

            } while (!correcto);

            correcto = false;

            do {

                System.out.println("Introduce la tasa de iva del artículo (formato 0.21):");
                System.out.print("> ");
                try {

                    tasaIva = Double.parseDouble(leer.nextLine());
                    correcto = true;

                } catch (NumberFormatException e) {

                    System.out.println("Formato inválido !!!");

                }

            } while (!correcto);

            correcto = false;

            totalSinIva += unidades * precio;
            ivaTotal += unidades * precio * tasaIva;
            total += unidades * precio * (1 + tasaIva);

            Ticket articulo = new Ticket(nombre,unidades,precio,tasaIva);
            producto.add(articulo);

            do {

                System.out.println("¿Siguiente artículo?(S/N)");
                String opcion = leer.next();
                leer.nextLine();
                if (opcion.equalsIgnoreCase("S")) {

                    System.out.println("Siguiente...");
                    correcto = true;

                } else if (opcion.equalsIgnoreCase("N")) {

                    salir = true;
                    correcto = true;

                } else {

                    System.out.println("Opción inválida !!!");

                }

            } while (!correcto);

        }

        System.out.println("Articulos: ");
        System.out.println(producto);

        System.out.println("-------------------------------------------------------");

        System.out.println("Total antes de impuestos: " + String.format("%.2f",totalSinIva)  + "€");
        System.out.println("Total de iva: " + String.format("%.2f",ivaTotal) + "€");
        System.out.println("Total a pagar: " + String.format("%.2f",total) + "€");


        leer.close();
    }

}
