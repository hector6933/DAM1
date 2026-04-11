package Modelo;

public class Departamento {

    private Integer numDep;
    private String nombre;

    public Departamento() {
    }

    public Departamento(Integer numDep, String nombre) {
        this.numDep = numDep;
        this.nombre = nombre;
    }

    public Integer getNumDep() {
        return numDep;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "numDep=" + numDep +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

