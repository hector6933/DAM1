package org.Modelo;

public class Curso {

    private Integer id;
    private String nombre;
    private Integer horas;

    public Curso(Integer id, String nombre, Integer horas) {
        this.id = id;
        this.nombre = nombre;
        this.horas = horas;
    }

    public Curso(String nombre, Integer horas) {
        this.nombre = nombre;
        this.horas = horas;
    }

    public Curso() {
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getHoras() {
        return horas;
    }
}
