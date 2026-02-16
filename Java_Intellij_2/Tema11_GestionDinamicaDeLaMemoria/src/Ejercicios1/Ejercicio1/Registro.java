package Ejercicios1.Ejercicio1;

import java.time.LocalDateTime;

public class Registro {

    private Integer id;
    private String nombre;
    private String apellidos;
    private String latitud;
    private String longitud;
    private String dominio;
    private String email;
    private String pais;
    private String ip;
    private LocalDateTime last_login;

    public Registro(Integer id, String nombre, String apellidos, String latitud, String longitud, String dominio, String email, String pais, String ip, LocalDateTime last_login) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.latitud = latitud;
        this.longitud = longitud;
        this.dominio = dominio;
        this.email = email;
        this.pais = pais;
        this.ip = ip;
        this.last_login = last_login;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", latitud='" + latitud + '\'' +
                ", dominio='" + dominio + '\'' +
                ", email='" + email + '\'' +
                ", pais='" + pais + '\'' +
                ", ip='" + ip + '\'' +
                ", last_login=" + last_login +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getLatitud() {
        return latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public String getDominio() {
        return dominio;
    }

    public String getEmail() {
        return email;
    }

    public String getPais() {
        return pais;
    }

    public String getIp() {
        return ip;
    }

    public LocalDateTime getLast_login() {
        return last_login;
    }
}
