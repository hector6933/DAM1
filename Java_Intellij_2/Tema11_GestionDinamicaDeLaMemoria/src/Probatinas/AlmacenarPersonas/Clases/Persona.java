package Probatinas.AlmacenarPersonas.Clases;

import java.util.Date;

public class Persona {

    private static Integer idSiguiente = 0;

    private Integer id;
    private String dni;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String sexo;
    private boolean enParo;


    public Persona(String dni, String nombre, String apellido, Integer edad, String sexo, boolean enParo) {

        this.id = idSiguiente;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
        this.enParo = enParo;

        idSiguiente++;

    }

    public Persona(String[] argumentos) {

        this.dni = argumentos[0];
        this.nombre = argumentos[1];
        this.apellido = argumentos[2];
        this.edad = Integer.parseInt(argumentos[3]);
        this.sexo = argumentos[4];
        this.enParo = Boolean.parseBoolean(argumentos[5]);


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

}
