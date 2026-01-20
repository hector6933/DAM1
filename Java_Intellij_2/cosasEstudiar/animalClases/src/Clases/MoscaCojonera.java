package Clases;

public class MoscaCojonera extends Insecto {

    public MoscaCojonera() {
    }

    public MoscaCojonera(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        super.setSonidoAnimal("bzzz toco los cojones bzzz");
        super.hacerSonido();
    }
}
