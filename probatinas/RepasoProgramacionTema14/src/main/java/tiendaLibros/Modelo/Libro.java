package tiendaLibros.Modelo;

public class Libro {

    private Integer id;
    private String titulo;
    private Double precio;
    private Integer idAutor;

    public Libro() {
    }

    public Libro(Integer id, String titulo, Double precio, Integer idAutor) {
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
        this.idAutor = idAutor;
    }

    public Libro(String titulo, Double precio, Integer idAutor) {
        this.titulo = titulo;
        this.precio = precio;
        this.idAutor = idAutor;
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Double getPrecio() {
        return precio;
    }

    public Integer getIdAutor() {
        return idAutor;
    }
}
