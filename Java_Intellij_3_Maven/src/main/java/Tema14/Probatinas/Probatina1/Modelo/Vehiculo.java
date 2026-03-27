package Tema14.Probatinas.Probatina1.Modelo;

import java.time.LocalDate;

public class Vehiculo {

    private String matricula;
    private String dniPropietario;
    private LocalDate fechaCompra;
    private String modelo;

    public Vehiculo() {
    }

    public Vehiculo(String matricula, String dniPropietario, LocalDate fechaCompra, String modelo) {
        this.matricula = matricula;
        this.dniPropietario = dniPropietario;
        this.fechaCompra = fechaCompra;
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getDniPropietario() {
        return dniPropietario;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public String getModelo() {
        return modelo;
    }
}
