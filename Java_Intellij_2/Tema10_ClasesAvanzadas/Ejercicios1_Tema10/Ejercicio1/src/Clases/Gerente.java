package Clases;

public class Gerente extends Empleado{

    private Double bono;

    public Gerente(String nombre, Double salario, Double bono) {
        super(nombre, salario);
        this.bono = bono;
    }

    @Override
    public void mostrarInfo(){

        System.out.println("| Nombre: " + super.getNombre() + " | Salario: " + super.getSalario() + " | Bono: "  + this.bono);

    }


    public Double getBono() {
        return bono;
    }

    public void setBono(Double bono) {
        this.bono = bono;
    }
}
