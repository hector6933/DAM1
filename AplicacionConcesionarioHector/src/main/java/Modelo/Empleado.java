package Modelo;

import java.sql.Date;

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

    public Empleado(String nombre, String apellidos, String telefono, Date fechaNacimiento, Integer numGerente, Integer numDep, Integer id_usuario) {
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

    public void setNumEmpleado(Integer numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setNumGerente(Integer numGerente) {
        this.numGerente = numGerente;
    }

    public void setNumDep(Integer numDep) {
        this.numDep = numDep;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
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
