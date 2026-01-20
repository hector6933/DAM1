package Clases;

public class Libro extends Publicacion {

    private Integer numeroPaginas;

    public Libro() {
    }

    public Libro(String titulo, String autor, Integer numeroPaginas) {
        super(titulo, autor);
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String mostrarInfo() {
        return "Libro{" +
                "titulo='" + super.getTitulo() + '\'' +
                ", autor='" + super.getAutor() + '\'' +
                ", numeroPaginas='" + numeroPaginas + '\'' +
                '}';
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
}
