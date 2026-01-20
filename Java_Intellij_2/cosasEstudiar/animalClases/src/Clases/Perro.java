package Clases;

public class Perro extends Animal {

    public Perro(){

    }

    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido(){

        super.setSonidoAnimal("Guau");
        super.hacerSonido();

    }

    public void getTetas(){

        System.out.println("hola");

    }

}
