package Demos;

import Clases.PayPal;
import Clases.TarjetaDeCredito;
import Clases.TransferenciaBancaria;

public class demo1 {

    public static void main(String[] args) {

        TarjetaDeCredito tarjeta1 = new TarjetaDeCredito();

        PayPal payPal1 = new PayPal();

        TransferenciaBancaria transferenciaBancaria = new TransferenciaBancaria();

        tarjeta1.procesarPago();
        payPal1.procesarPago();
        transferenciaBancaria.procesarPago();

    }

}
