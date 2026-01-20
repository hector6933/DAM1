package Clases;

public class EmpleadoPorHoras extends Empleado {

    private Integer horasTrabajadas;
    private Double tarifaHora;

    public EmpleadoPorHoras(){

    }

    public EmpleadoPorHoras(String nombre, Integer horasTrabajadas, Double tarifaHora) {
        super(nombre);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaHora = tarifaHora;
    }

    @Override
    public Double calcularSalario() {
        super.setSalario(horasTrabajadas*tarifaHora);
        return super.calcularSalario();
    }

    @Override
    public Double getSalario() {
       return calcularSalario();
    }

    public Integer getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(Integer horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public Double getTarifaHora() {
        return tarifaHora;
    }

    public void setTarifaHora(Double tarifaHora) {
        this.tarifaHora = tarifaHora;
    }
}
