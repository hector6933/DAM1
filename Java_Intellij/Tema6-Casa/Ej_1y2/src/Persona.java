import java.time.LocalDate;
import java.time.Period;

public class Persona {

    private String nombre;
    private String apellidos;
    private LocalDate fechaNaci;
    private String DNI;
    private char sexo;

    public Persona() {
    }

    public Persona(String nombre, String apellidos, LocalDate fechaNaci, String DNI, char sexo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNaci = fechaNaci;
        this.DNI = DNI;
        this.sexo = sexo;
    }

    public Persona(LocalDate fechaNaci, String nombre) {
        this.fechaNaci = fechaNaci;
        this.nombre = nombre;
    }

    public Persona(String nombre) {
        this.nombre = nombre;
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

    public LocalDate getFechaNaci() {
        return fechaNaci;
    }

    public void setFechaNaci(LocalDate fechaNaci) {
        this.fechaNaci = fechaNaci;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String saludar() {

        return "Hola soy " + nombre;

    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNaci=" + fechaNaci +
                ", DNI='" + DNI + '\'' +
                ", sexo=" + sexo +
                '}';
    }

    public Integer calcularEdad() {

        return Period.between(fechaNaci,LocalDate.now()).getYears();

    }
}
