package Clases;

public class Vehiculo {

    private String marca;
    private String modelo;

    public Vehiculo(){

    }

    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void arrancar(){

        System.out.println("Arrancando vehiculo...");

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
}
