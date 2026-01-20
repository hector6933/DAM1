package Clases;

public class Animal {

    private String sonidoAnimal;
    private String nombre;

    public Animal(){

    }

    public void hacerSonido(){

        System.out.println(sonidoAnimal);

    }

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSonidoAnimal() {
        return sonidoAnimal;
    }

    public void setSonidoAnimal(String sonidoAnimal) {
        this.sonidoAnimal = sonidoAnimal;
    }
}
