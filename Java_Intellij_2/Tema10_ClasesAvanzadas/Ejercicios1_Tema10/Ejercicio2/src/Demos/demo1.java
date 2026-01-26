package Demos;

import Clases.Auto;
import Clases.Camion;
import Clases.Motocicleta;

public class demo1 {

    public static void main(String[] args) {

        Auto coche1 = new Auto("Permiso B",1500.0,30000.0,"Samsung Galaxy",4);
        Motocicleta moto1 = new Motocicleta("Permiso B",1500.0,30000.0,"Samsung Galaxy",4);
        Camion camion1 = new Camion("Permiso B",1500.0,30000.0,"Samsung Galaxy",4);

        coche1.describirVehiculo();
        moto1.describirVehiculo();
        camion1.describirVehiculo();

    }

}
