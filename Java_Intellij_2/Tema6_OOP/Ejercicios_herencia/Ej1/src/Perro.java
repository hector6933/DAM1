public class Perro extends Animal{

    @Override
    public void hacerSonido() {

        super.sonido = "Guau";
        super.hacerSonido();

    }
}
