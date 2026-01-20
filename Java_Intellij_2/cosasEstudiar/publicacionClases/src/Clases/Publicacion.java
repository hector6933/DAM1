package Clases;

public class Publicacion {

    private String titulo;
    private String autor;

    public Publicacion() {
    }

    public Publicacion(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String mostrarInfo() {
        return "Publicacion{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return "Publicacion{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
