package Clases;

import java.time.LocalDate;

public class Vehiculo {

    private String marca;
    private String modelo;
    private Integer anioFabricacion;
    private String matricula;
    private Double precio;

    public Vehiculo(String marca, String modelo, Integer anioFabricacion, String matricula, Double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.matricula = matricula;
        this.precio = precio;
    }

    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }

    public Integer calcularAntiguedad(){

        return LocalDate.now().getYear() - anioFabricacion;

    }

    public String descripcion(){

        return "Vehiculo marca" + marca + " modelo " + modelo + " año " + anioFabricacion + " matricula " + matricula + " precio " + precio;

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(Integer anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
