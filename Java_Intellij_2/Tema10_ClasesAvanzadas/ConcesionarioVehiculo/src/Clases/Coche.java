package Clases;

public class Coche extends Vehiculo{

    private Integer numPuertas;
    private String combustible;

    public Coche(String marca, String modelo, Integer anioFabricacion, String matricula, Double precio, Integer numPuertas, String combustible) {
        super(marca, modelo, anioFabricacion, matricula, precio);
        this.numPuertas = numPuertas;
        this.combustible = combustible;
    }

    public Integer getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(Integer numPuertas) {
        this.numPuertas = numPuertas;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    @Override
    public String descripcion() {
        return "Coche marca " + super.getMarca() + " modelo " + super.getModelo() + " año " + super.getAnioFabricacion() + " matricula " + super.getMatricula() + " precio " + super.getPrecio() + " numero de puertas " + numPuertas + " combustible " + combustible;
    }
}
