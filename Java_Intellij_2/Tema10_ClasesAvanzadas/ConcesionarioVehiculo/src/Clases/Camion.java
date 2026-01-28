package Clases;

public class Camion extends Vehiculo{

    private Double capacidadCarga;
    private Integer numEjes;

    public Camion(String marca, String modelo, Integer anioFabricacion, String matricula, Double precio, Double capacidadCarga, Integer numEjes) {
        super(marca, modelo, anioFabricacion, matricula, precio);
        this.capacidadCarga = capacidadCarga;
        this.numEjes = numEjes;
    }

    public Double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(Double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public Integer getNumEjes() {
        return numEjes;
    }

    public void setNumEjes(Integer numEjes) {
        this.numEjes = numEjes;
    }

    @Override
    public String descripcion() {

        return "Camion marca " + super.getMarca() + " modelo " + super.getModelo() + " año " + super.getAnioFabricacion() + " matricula " + super.getMatricula() + " precio " + super.getPrecio() + " capacidad de la carga " + capacidadCarga + " numero de ejes " + numEjes;

    }
}
