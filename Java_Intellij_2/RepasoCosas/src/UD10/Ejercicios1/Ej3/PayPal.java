package UD10.Ejercicios1.Ej3;

public class PayPal extends MetodoPago {

    @Override
    public double procesarPago(double monto) {
        System.out.println("Procesando pago con PayPal");
        return 0;
    }
}
