package Clases;

public class Auto extends Vehiculo{

    public Auto(String PERMISOCONDUCCION, Double peso, Double precio, String modelo, int puertas) {
        super(PERMISOCONDUCCION, peso, precio, modelo, puertas);
    }

    @Override
    public void describirVehiculo(){

        System.out.println("Esto es un auto");

    }

}
