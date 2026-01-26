package Demos;

import Clases.CuentaBancaria;

public class demo1 {

    public static void main(String[] args) {

        CuentaBancaria cuenta1 = new CuentaBancaria("Alonso Soriano",0.0);
        CuentaBancaria cuenta2 = new CuentaBancaria("Alonso Soriano",0.0);

        cuenta1.setTitular("Héctor");

        cuenta1.depositar(150.33);

        cuenta1.depositar(200.0);

        // cuenta1.retirar(2000.0);

        System.out.println("El titula de la cuenta es " + cuenta1.getTitular());

        cuenta1.mostrarSaldo();

        System.out.println("Número de cuenta de la cuenta 1: " + cuenta1.getNumeroDeCuenta());
        System.out.println("Número de cuenta de la cuenta 1: " + cuenta2.getNumeroDeCuenta());

    }

}
