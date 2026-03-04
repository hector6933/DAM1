package UD10.Ejercicios1.Ej1;

public class Gerente extends Empleado {

    private Double bono;

    public Gerente(String nombre, Double salarioBase, Double bono) {
        super(nombre, salarioBase);
        this.bono = bono;
    }

    public Double getBono() {
        return bono;
    }

    public void setBono(Double bono) {
        this.bono = bono;
    }

    @Override
    public void mostrarInfo() {

        System.out.println("Gerente{" +
                "nombre='" + super.getNombre() + '\'' +
                ", salarioBase=" + super.getSalarioBase() +
                ", bono=" + bono +
                '}');
    }

}
