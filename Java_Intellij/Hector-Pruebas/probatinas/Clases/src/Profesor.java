public class Profesor extends Personas{

    private Double salario;
    private Boolean esCabron;

    public Profesor() {
    }

    public Profesor(String nombre, Double peso, Double altura, Integer edad, String dni, Double salario, Boolean esCabron) {

        super(nombre, peso, altura, edad, dni);
        this.salario = salario;
        this.esCabron = esCabron;

    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Boolean getEsCabron() {
        return esCabron;
    }

    public void setEsCabron(Boolean esCabron) {
        this.esCabron = esCabron;
    }

    @Override
    public String toString() {
        return super.toString() + "Profesor{" +
                "salario=" + salario +
                ", esCabron=" + esCabron +
                '}';
    }

    @Override
    public String info() {
        return super.info() + ", esCabron=" + esCabron;
    }
}
