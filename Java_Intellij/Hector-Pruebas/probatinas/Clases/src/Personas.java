public class Personas {

    private String nombre;
    private Double peso;
    private Double altura;
    private Integer edad;
    private String dni;

    // Constructor Personas
    public Personas() {

    }

    public Personas(String nombre) {
        this.nombre = nombre;
    }

    public Personas(String nombre, Double peso, Double altura, Integer edad, String dni) {

        this(nombre);
        this.peso = peso;
        this.altura = altura;
        this.edad = edad;
        this.dni = dni;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Personas{" +
                "nombre='" + nombre + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                '}';
    }

    public String info() {

        return  "nombre='" + nombre + '\'' + ", dni='" + dni + '\'';

    }
}
