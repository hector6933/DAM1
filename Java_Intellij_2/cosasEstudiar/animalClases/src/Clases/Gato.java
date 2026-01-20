package Clases;

public class Gato extends Animal{

    public Gato(){

    }

    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido(){

        super.setSonidoAnimal("Miau");
        super.hacerSonido();

    }

}
