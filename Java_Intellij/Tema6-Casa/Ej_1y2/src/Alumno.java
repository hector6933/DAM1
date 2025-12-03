import java.time.LocalDate;

public class Alumno extends Persona{

    private int curso;
    private char grupo;
    private String asignaturas;

    public Alumno(String nombre, String apellidos, LocalDate fechaNaci, String DNI, char sexo, String asignaturas, char grupo, int curso) {
        super(nombre, apellidos, fechaNaci, DNI, sexo);
        this.asignaturas = asignaturas;
        this.grupo = grupo;
        this.curso = curso;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public char getGrupo() {
        return grupo;
    }

    public void setGrupo(char grupo) {
        this.grupo = grupo;
    }

    public String getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(String asignaturas) {
        this.asignaturas = asignaturas;
    }
}
