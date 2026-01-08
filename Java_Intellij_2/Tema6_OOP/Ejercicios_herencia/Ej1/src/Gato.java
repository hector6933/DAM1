public class Gato extends Animal{

    @Override
    public void hacerSonido() {

        super.sonido = "Miau";
        super.hacerSonido();

    }

}
