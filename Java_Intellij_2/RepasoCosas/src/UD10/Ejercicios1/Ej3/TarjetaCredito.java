package UD10.Ejercicios1.Ej3;

public class TarjetaCredito extends MetodoPago{

    @Override
    public double procesarPago(double monto) {
        System.out.println("Procesando el pago con Tarjeta de Crédito");
        return 0;
    }
}
