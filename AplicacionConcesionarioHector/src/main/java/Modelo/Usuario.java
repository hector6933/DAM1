package Modelo;

import java.util.regex.Pattern;

public class Usuario {

    private Integer id;
    private String nombre;
    private String passwd;
    private String rol;

    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String passwd, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.passwd = passwd;
        this.rol = rol;
    }

    public Usuario(String nombre, String passwd, String rol) {
        this.nombre = nombre;
        this.passwd = passwd;
        this.rol = rol;
    }

    public static boolean validarUsername(String nom,Integer min, Integer max){

        return Pattern.matches("^[A-Za-zñÑ0-9\\-_.]{" + min + ","+ max + "}$",nom);

    }

    public static boolean validarPasswd(String passwd) {

        return Pattern.matches("^(?=\\S*[A-Z])(?=\\S*[._\\-$&@%/€#])(?=\\S*[0-9])\\S{8,}$",passwd);

    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getRol() {
        return rol;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", passwd='" + passwd + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
