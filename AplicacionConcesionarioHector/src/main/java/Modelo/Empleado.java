package Modelo;

import java.util.Date;

public class Empleado {

    private Integer numEmpleado;
    private String nombre;
    private String apellidos;
    private String telefono;
    private Date fechaNacimiento;
    private Integer numGerente;
    private Integer numDep;
    private Integer id_usuario;

    public Empleado() {
    }

    public Empleado(Integer numEmpleado, String nombre, String apellidos, String telefono, Date fechaNacimiento, Integer numGerente, Integer numDep, Integer id_usuario) {
        this.numEmpleado = numEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.numGerente = numGerente;
        this.numDep = numDep;
        this.id_usuario = id_usuario;
    }

    public Integer getNumEmpleado() {
        return numEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Integer getNumGerente() {
        return numGerente;
    }

    public Integer getNumDep() {
        return numDep;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "numEmpleado=" + numEmpleado +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", numGerente=" + numGerente +
                ", numDep=" + numDep +
                ", id_usuario=" + id_usuario +
                '}';
    }
}
