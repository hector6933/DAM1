package Demos;

import Clases.*;

import java.awt.image.ComponentColorModel;
import java.sql.Array;
import java.util.ArrayList;

public class demoVehiculos {

    public static void main(String[] args) {

        ArrayList<Vehiculo> misVehiculos = new ArrayList<>();

        misVehiculos.add(new Coche("Samsung","S23"));
        misVehiculos.add(new Coche("Paracetamol","2g"));
        misVehiculos.add(new Coche("Nvidia","4090"));

        misVehiculos.add(new Motocicleta("El pozo","Jamon"));
        misVehiculos.add(new Motocicleta("Addidas","Sudadera"));
        misVehiculos.add(new Motocicleta("Tesla","Cybertruck"));

        for (Vehiculo e : misVehiculos) {

            if (e instanceof Coche) {

                System.out.print(e.getMarca() + ": ");
                ((Coche) e).abrirMaletero();

            } else if (e instanceof Motocicleta) {

                System.out.print(e.getMarca() + ": ");
                ((Motocicleta) e).hacerCaballito();

            }

        }

    }

}
