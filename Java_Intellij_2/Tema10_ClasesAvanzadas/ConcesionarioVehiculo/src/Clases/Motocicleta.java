package Clases;

public class Motocicleta extends Vehiculo{

    private Integer cilindrada;
    private String tipo;

    public Motocicleta(String marca, String modelo, Integer anioFabricacion, String matricula, Double precio, Integer cilindrada, String tipo) {
        super(marca, modelo, anioFabricacion, matricula, precio);
        this.cilindrada = cilindrada;
        this.tipo = tipo;
    }

    public Integer getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(Integer cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String descripcion() {
        return "Motocicleta marca " + super.getMarca() + " modelo " + super.getModelo() + " año " + super.getAnioFabricacion() + " matricula " + super.getMatricula() + " precio " + super.getPrecio() + " cilindrada " + cilindrada + " tipode moto " + tipo;
    }
}
