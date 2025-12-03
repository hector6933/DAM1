public class Ticket {

    private String nombreArt;
    private Integer unidades;
    private Double precio;
    private Double tasaIva;

    public Ticket() {
    }

    public Ticket(String nombreArt, Integer unidades, Double precio, Double tasaIva) {
        this.nombreArt = nombreArt;
        this.unidades = unidades;
        this.precio = precio;
        this.tasaIva = tasaIva;
    }

    public String getNombreArt() {
        return nombreArt;
    }

    public void setNombreArt(String nombreArt) {
        this.nombreArt = nombreArt;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getTasaIva() {
        return tasaIva;
    }

    public void setTasaIva(Double tasaIva) {
        this.tasaIva = tasaIva;
    }

    public Double valorLinea() {

        return unidades * precio;

    }

    @Override
    public String toString() {
        return "\nTicket{" +
                "nombreArt='" + nombreArt + '\'' +
                ", unidades=" + unidades +
                ", precio=" + precio +
                ", tasaIva=" + tasaIva +
                '}';
    }
}
