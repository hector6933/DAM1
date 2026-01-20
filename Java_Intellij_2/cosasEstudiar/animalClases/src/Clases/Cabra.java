package Clases;

public class Cabra extends Animal {

    public Cabra(){

    }

    public Cabra(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        super.setSonidoAnimal("Beee o yo que se");
        super.hacerSonido();
    }
}
