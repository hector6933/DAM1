package org.Modelo;

public class Autor {

    private String nombre;
    private String pais;

    public Autor() {
    }

    public Autor(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }


    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }
}
