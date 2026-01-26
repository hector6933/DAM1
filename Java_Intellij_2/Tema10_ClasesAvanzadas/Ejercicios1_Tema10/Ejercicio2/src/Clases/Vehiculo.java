package Clases;

public class Vehiculo {

    private int puertas;
    private String modelo;
    private Double precio;
    private Double peso;
    private final String PERMISOCONDUCCION;

    public Vehiculo(String PERMISOCONDUCCION, Double peso, Double precio, String modelo, int puertas) {
        this.PERMISOCONDUCCION = PERMISOCONDUCCION;
        this.peso = peso;
        this.precio = precio;
        this.modelo = modelo;
        this.puertas = puertas;
    }

    public void describirVehiculo() {

        System.out.println("Mensaje por defecto de un vehículo");

    }


    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}
