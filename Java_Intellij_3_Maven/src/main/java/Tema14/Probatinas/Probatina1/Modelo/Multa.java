package Tema14.Probatinas.Probatina1.Modelo;

import java.time.LocalDate;

public class Multa {

    private Integer id;
    private String matriculaVehiculo;
    private String dniPropietario;
    private LocalDate fecha;
    private Double euros;

    public Multa() {
    }

    public Multa(Integer id, String matriculaVehiculo, String dniPropietario, LocalDate fecha, Double euros) {
        this.id = id;
        this.matriculaVehiculo = matriculaVehiculo;
        this.dniPropietario = dniPropietario;
        this.fecha = fecha;
        this.euros = euros;
    }

    public Integer getId() {
        return id;
    }

    public String getMatriculaVehiculo() {
        return matriculaVehiculo;
    }

    public String getDniPropietario() {
        return dniPropietario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Double getEuros() {
        return euros;
    }
}
