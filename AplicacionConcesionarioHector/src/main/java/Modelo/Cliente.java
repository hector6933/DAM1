package Modelo;

import java.util.regex.Pattern;

public class Cliente {

    private String dni;
    private String nombre;
    private String apellidos;
    private String telefono;

    public Cliente() {
    }

    public Cliente(String dni, String nombre, String apellidos, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }

    public static boolean validarDni(String dni){

        return Pattern.matches("^[0-9]{8}[A-Z]$",dni);

    }

    public String getDni() {
        return dni;
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

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
