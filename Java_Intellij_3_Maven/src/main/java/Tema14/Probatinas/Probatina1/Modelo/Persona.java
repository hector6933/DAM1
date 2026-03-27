package Tema14.Probatinas.Probatina1.Modelo;

public class Persona {

    private String dni;
    private String nombre;
    private String telefono;
    private Integer edad;

    public Persona() {
    }

    public Persona(String dni, String nombre, String telefono, Integer edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public Integer getEdad() {
        return edad;
    }
}
