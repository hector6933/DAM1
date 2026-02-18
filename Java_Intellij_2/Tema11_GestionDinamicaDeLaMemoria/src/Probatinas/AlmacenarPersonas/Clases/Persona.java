package Probatinas.AlmacenarPersonas.Clases;

import java.util.Date;

public class Persona {

    private static Integer idSiguiente;

    private Integer id;
    private String dni;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String sexo;
    private boolean enParo;
    private Date fechaNacimiento;

    public Persona(String dni, String nombre, String apellido, Integer edad, String sexo, boolean enParo, Date fechaNacimiento) {

        this.id = idSiguiente;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
        this.enParo = enParo;
        this.fechaNacimiento = fechaNacimiento;
        idSiguiente++;

    }

    public Persona(String[] argumentos) {

        this.dni = argumentos[0];
        this.nombre = argumentos[1];
        this.apellido = argumentos[2];
        this.edad = Integer.parseInt(argumentos[3]);
        this.sexo = argumentos[4];
        this.enParo = Boolean.parseBoolean(argumentos[5]);
        String[] fecha = argumentos[6].split("^\\d");
        this.fechaNacimiento = new Date(Integer.parseInt(fecha[2]),Integer.parseInt(fecha[1]),Integer.parseInt(fecha[0]));

    }

    public static Integer getIdSiguiente() {
        return idSiguiente;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public boolean isEnParo() {
        return enParo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
}
