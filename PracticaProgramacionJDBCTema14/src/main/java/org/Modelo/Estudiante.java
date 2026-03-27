package org.Modelo;

public class Estudiante {

    private Integer id;
    private String nombre;
    private Integer edad;
    private Integer curso;



    public Estudiante(Integer id, String nombre, Integer edad, Integer curso) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
    }

    public Estudiante( String nombre, Integer edad, Integer curso) {
        this.curso = curso;
        this.edad = edad;
        this.nombre = nombre;
    }

    public Estudiante() {
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public Integer getCurso() {
        return curso;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", curso=" + curso +
                '}';
    }
}
