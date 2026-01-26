package Clases;

public class CuentaBancaria {

    private static Integer siguienteNumero = 0;

    private Integer numeroDeCuenta;
    private String titular;
    private Double saldo;

    public CuentaBancaria(String titular, Double saldo) {
        this.numeroDeCuenta = siguienteNumero;
        siguienteNumero++;
        this.titular = titular;
        this.saldo = saldo;
    }

    public void mostrarSaldo(){

        System.out.println("Saldo actual de la cuenta: " + String.format("%.2f",this.saldo));

    }

    public void retirar(Double cantidad){

        if (cantidad <= 0) {

            System.out.println("La cantidad a retirar debe de ser mayor o igual a 0");

        } else if (saldo < cantidad) {

            System.out.println("No hay suficiente saldo para retirar !!!");

        } else {

            saldo -= cantidad;

        }

    }

    public void depositar(Double cantidad) {

        if (cantidad <= 0) {

            System.out.println("La cantidad debe de ser mayor que 0");

        } else {

            this.saldo += cantidad;

        }

    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Integer getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(Integer numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }
}
