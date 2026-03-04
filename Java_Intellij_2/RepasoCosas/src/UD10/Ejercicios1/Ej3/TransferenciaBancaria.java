package UD10.Ejercicios1.Ej3;

public class TransferenciaBancaria extends MetodoPago{

    @Override
    public double procesarPago(double monto) {
        System.out.println("Procesando pago por Transferencia Bancaria");
        return 0;
    }
}
