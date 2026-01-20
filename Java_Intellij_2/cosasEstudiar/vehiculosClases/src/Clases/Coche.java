package Clases;

public class Coche extends Vehiculo {

    public Coche() {
    }

    public Coche(String marca, String modelo) {
        super(marca, modelo);
    }

    public void abrirMaletero(){

        System.out.println("Abriendo el maletero...");

    }
}
