import java.time.LocalDate;
import java.time.Period;

public class Persona {

    private String nombre;
    private int edad;
    private String dni;
    private double altura;
    private LocalDate fechaNaci;

    public LocalDate getFechaNaci() {
        return fechaNaci;
    }

    public void setFechaNaci(LocalDate fechaNaci) {
        this.fechaNaci = fechaNaci;
    }

    public Persona() {

    }

    public Persona(String nombre, int edad, String dni, double altura, LocalDate fechaNaci) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.altura = altura;
        this.fechaNaci = fechaNaci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int fechaAnios() {

        return Period.between(fechaNaci,LocalDate.now()).getYears();

    }

    @Override
    public String toString() {
        return " nombre:" + nombre + " edad: " + edad +" dni: " + dni +" altura: " + altura;
    }

}
