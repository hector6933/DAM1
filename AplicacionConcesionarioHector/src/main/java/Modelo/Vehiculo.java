package Modelo;

import java.util.regex.Pattern;

public class Vehiculo {

    private String matricula;
    private String marca;
    private String modelo;
    private String tipoCombustible;
    private Double precio;
    private String dniCliente;
    private Integer numEmpleado;

    public Vehiculo() {
    }

    public Vehiculo(String matricula, String marca, String modelo, String tipoCombustible, Double precio, String dniCliente, Integer numEmpleado) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.tipoCombustible = tipoCombustible;
        this.precio = precio;
        this.dniCliente = dniCliente;
        this.numEmpleado = numEmpleado;
    }

    public static boolean validarModelo(String modelo){

        return Pattern.matches("^\\w{2,15}$",modelo);

    }

    public static boolean validarMatricula(String matricula){

        return Pattern.matches("^[0-9]{4}-[BCDFGHJKLMNPQRSTVWXYZ]{3}$",matricula);

    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public Double getPrecio() {
        return precio;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public Integer getNumEmpleado() {
        return numEmpleado;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", tipoCombustible='" + tipoCombustible + '\'' +
                ", precio=" + precio +
                ", dniCliente='" + dniCliente + '\'' +
                ", numEmpleado=" + numEmpleado +
                '}';
    }
}
