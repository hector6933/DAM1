package Clases;

import java.util.regex.Pattern;

public class Usuario {

    private String usuario;
    private String passwd;

    public Usuario(String usuario, String passwd) {

        cambiarPasswd(passwd);

        this.usuario = usuario;

    }

    public void cambiarPasswd(String ingreso){

        boolean validarPasswd = Pattern.matches("^(?=\\S*[A-Z])(?=\\S*\\d)\\S{8,}$",ingreso);
        if (validarPasswd) {

            passwd = ingreso;
            System.out.println("Contraseña cambiada correctamente!");

        } else {

            throw new IllegalArgumentException("La contraseña debe de cumplir los requisitos");

        }

    }

    public boolean verificarPasswd(String ingreso) {

        return ingreso.equals(passwd);

    }

}