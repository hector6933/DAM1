public class Empleado {

    private String nombre;
    private Double salario;

    public Empleado() {
    }

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public Empleado(String nombre, Double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public Double calcularSalario() {

        return salario;

    }
}
