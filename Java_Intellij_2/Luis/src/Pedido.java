public class Pedido {

    public void procesarPedido(String tipoCliente, double totalCompra) {

        if (tipoCliente.equalsIgnoreCase("NORMAL")) {

            descuentoClienteNormal(totalCompra);

        } else if (tipoCliente.equalsIgnoreCase("VIP")) {

            descuentoClienteVip(totalCompra);

        } else {

            System.out.println("Tipo de cliente desconocido");
        }
    }

    public static void descuentoClienteNormal(double totalCompra){

        if (totalCompra > 100) {

            System.out.println("Descuento 5%");
            System.out.println("Total: " + gestionDescuento.aplicarDescuento(totalCompra,0.05));

        } else {

            System.out.println("Sin descuento");
            System.out.println("Total: " + totalCompra);

        }

    }

    public static void descuentoClienteVip(double totalCompra){

        if (totalCompra > 100) {

            System.out.println("Descuento 20%");
            System.out.println("Total: " + gestionDescuento.aplicarDescuento(totalCompra,0.20));

        } else {

            System.out.println("Descuento 10%");
            System.out.println("Total: " + gestionDescuento.aplicarDescuento(totalCompra,0.10));
        }

    }

}