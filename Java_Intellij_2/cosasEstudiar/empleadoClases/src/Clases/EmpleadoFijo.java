package Clases;

public class EmpleadoFijo extends Empleado {

    private Integer aniosTrabajado;

    public EmpleadoFijo(){

    }

    public EmpleadoFijo(String nombre, Double salario, Integer aniosTrabajado) {
        super(nombre, salario);
        this.aniosTrabajado = aniosTrabajado;
    }

    public Integer getAniosTrabajado() {
        return aniosTrabajado;
    }

    public void setAniosTrabajado(Integer aniosTrabajado) {
        this.aniosTrabajado = aniosTrabajado;
    }
}
