package probatinas;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@XmlRootElement(name = "Alumno")
public class Alumno {

    private static int idSiguiente;

    private int id;
    private String nombre;
    private String apellidos;
    private Integer edad;
    private String dni;
    private Date fechaMatricula;

    private HashMap<String, Double> notas;
    private ArrayList<String> asignaturas;

    public Alumno() {
    }

    public Alumno(String nombre, String apellidos, Integer edad, String dni, Date fechaMatricula) {
        id = idSiguiente;
        idSiguiente++;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.dni = dni;
        this.fechaMatricula = fechaMatricula;
    }

    public Alumno(String nombre, String apellidos, Integer edad, String dni, Date fechaMatricula, HashMap<String, Double> notas, ArrayList<String> asignaturas) {
        id = idSiguiente;
        idSiguiente++;
        this.nombre = nombre;
        this.apellidos = apellidos;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getIdSiguiente() {
        return idSiguiente;
    }

    public static void setIdSiguiente(int idSiguiente) {
        Alumno.idSiguiente = idSiguiente;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", fechaMatricula=" + fechaMatricula +
                ", notas=" + notas +
                ", asignaturas=" + asignaturas +
                '}';
    }
}
