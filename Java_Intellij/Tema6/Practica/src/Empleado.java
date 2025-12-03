import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Empleado {

    private String nombre;
    private String apellidos;
    private LocalDate fechaContrat;
    private String DNI;
    private Double salario;
    private String puesto;

    private static int id = 0;
    private int IdPersona;

    public Empleado() {
        id++;
    }

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public Empleado(String nombre, LocalDate fechaContrat) {
        this.nombre = nombre;
        this.fechaContrat = fechaContrat;
    }

    public Empleado(String nombre, String apellidos, LocalDate fechaContrat, String DNI, Double salario, String puesto) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaContrat = fechaContrat;
        this.DNI = DNI;
        this.salario = salario;
        this.puesto = puesto;
        IdPersona = id;
        id++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaContrat() {
        return fechaContrat;
    }

    public void setFechaContrat(LocalDate fechaContrat) {
        this.fechaContrat = fechaContrat;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String trabajar() {

        return "Estoy trabajando como " + puesto;

    }

    public int getAntiguedad() {

        return (int) ChronoUnit.YEARS.between(LocalDate.now(),fechaContrat);

    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaContrat=" + fechaContrat +
                ", DNI='" + DNI + '\'' +
                ", salario=" + salario +
                ", puesto='" + puesto + '\'' + " id: " + IdPersona +
                '}';
    }
}
