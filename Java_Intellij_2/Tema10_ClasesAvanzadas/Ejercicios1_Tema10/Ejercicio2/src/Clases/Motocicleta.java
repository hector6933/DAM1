package Clases;

public class Motocicleta  extends Vehiculo {


    public Motocicleta(String PERMISOCONDUCCION, Double peso, Double precio, String modelo, int puertas) {
        super(PERMISOCONDUCCION, peso, precio, modelo, puertas);
    }

    @Override
    public void describirVehiculo(){

        System.out.println("Esto es una motocicleta");

    }


}
