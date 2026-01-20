package Clases;

public class Revista extends Publicacion {

    private Integer numeroEdicion;

    public Revista(){

    }

    public Revista(String titulo, String autor, Integer numeroEdicion) {
        super(titulo, autor);
        this.numeroEdicion = numeroEdicion;
    }

    @Override
    public String mostrarInfo() {
        return "Revista{" +
                "titulo='" + super.getTitulo() + '\'' +
                ", autor='" + super.getAutor() + '\'' +
                ", numeroPaginas='" + numeroEdicion + '\'' +
                '}';
    }

    public Integer getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(Integer numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }
}
