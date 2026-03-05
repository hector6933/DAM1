package probatinas;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Alumno {

    private String nombre;
    private Integer edad;
    private String dni;
    private Date fechaMatricula;

    private HashMap<String, Double> notas;
    private ArrayList<String> asignaturas;

    public Alumno(String nombre, Integer edad, String dni, Date fechaMatricula) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.fechaMatricula = fechaMatricula;
        notas = new HashMap<>();
        asignaturas = new ArrayList<>();
    }

    public Alumno(String nombre, Integer edad, String dni, Date fechaMatricula, HashMap<String, Double> notas, ArrayList<String> asignaturas) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.fechaMatricula = fechaMatricula;
        this.notas = notas;
        this.asignaturas = asignaturas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public HashMap<String, Double> getNotas() {
        return notas;
    }

    public void setNotas(HashMap<String, Double> notas) {
        this.notas = notas;
    }

    public ArrayList<String> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<String> asignaturas) {
        this.asignaturas = asignaturas;
    }
}
