public class EmpleadoPorHoras extends Empleado {

    private int horas;
    private Double tarifaHoras;

    public EmpleadoPorHoras() {
    }

    public EmpleadoPorHoras(String nombre, int horas, Double tarifaHora) {
        super(nombre);

        this.horas = horas;
        this.tarifaHoras = tarifaHora;

    }

    @Override
    public Double calcularSalario() {

        return horas*tarifaHoras;

    }

}
