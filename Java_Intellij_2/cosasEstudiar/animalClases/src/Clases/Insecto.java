package Clases;

public class Insecto extends Animal {

    private Boolean molesto = false;
    private Boolean volador;

    public Insecto() {
    }

    public Insecto(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        super.hacerSonido();
    }

    public Boolean getMolesto() {
        return molesto;
    }

    public void setMolesto(Boolean molesto) {
        this.molesto = molesto;
    }

    public Boolean getVolador() {
        return volador;
    }

    public void setVolador(Boolean volador) {
        this.volador = volador;
    }
}
