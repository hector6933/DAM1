package org.Modelo;

public class Libro {

    private String titulo;
    private Double precio;
    private int id_autor;

    public Libro() {
    }

    public Libro(String titulo, Double precio, int id_autor) {
        this.titulo = titulo;
        this.precio = precio;
        this.id_autor = id_autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public Double getPrecio() {
        return precio;
    }

    public int getId_autor() {
        return id_autor;
    }
}
