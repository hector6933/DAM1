package prob1_Personas;

public class Persona {

    private String nombre;
    private Integer edad;
    private boolean activo;
    private Character sexo;
    private String grupo;

    public Persona(String nombre, String grupo, Integer edad, boolean activo, Character sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.activo = activo;
        this.sexo = sexo;
        this.grupo = grupo;
    }

    public Persona(String nombre, Integer edad, boolean activo, Character sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.activo = activo;
        this.sexo = sexo;
    }

    public Persona(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", grupo='" + grupo + '\'' +
                ", edad=" + edad +
                ", activo=" + activo +
                ", sexo=" + sexo +
                '}';
    }
}
