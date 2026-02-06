package Ejercicios1.Ejercicio1;

import java.time.LocalDateTime;
import java.util.Date;

public class Registro {

    private String nombre;
    private String apellidos;
    private String latitud;
    private String dominio;
    private String email;
    private String pais;
    private String ip;
    private LocalDateTime last_login;

    public Registro(String nombre, String apellidos, String latitud, String dominio, String email, String pais, String ip, LocalDateTime last_login) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.latitud = latitud;
        this.dominio = dominio;
        this.email = email;
        this.pais = pais;
        this.ip = ip;
        this.last_login = last_login;
    }
}
