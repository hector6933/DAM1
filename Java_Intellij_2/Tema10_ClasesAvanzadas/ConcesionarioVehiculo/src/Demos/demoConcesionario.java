package Demos;
import Clases.*;

public class demoConcesionario {

    public static void main(String[] args) {

        Concesionario concesionario1 = new Concesionario();

        concesionario1.getVehiculos().add(new Coche("Samsumg","33",2000,"ADJAW-33",35000.0,5,"Gasolina ;)"));
        concesionario1.getVehiculos().add(new Coche("asd","asd",2012300,"asd-33",35000.0,5,"Gasolina ;)"));
        concesionario1.getVehiculos().add(new Motocicleta("Oppo","A80",1990,"HOLAQUETAL-67",58000.0,50,"Ni idea"));
        concesionario1.getVehiculos().add(new Camion("Oppo","33",1980,"HOLAQUETAL-67",58000.0,50000.0,4));
        concesionario1.getVehiculos().add(new Camion("Alonso","33",1980,"HOLAQUETAL-67",58000.0,50000.0,4));
        concesionario1.getVehiculos().add(new Camion("Alonso","24",2007,"asmadw-67",100000.0,50000.0,4));

        concesionario1.mostrarVehiculos();

        System.out.println("--------------------------------------");
        System.out.println("Vehiculo más antigüo:");
        System.out.println(concesionario1.vehiculoMasAntiguo().descripcion());

        System.out.println("--------------------------------------");
        System.out.println("Búsqueda de un Vehículo por marca: ");
        for (Vehiculo e: concesionario1.buscarVehiculos("Oppo")) {

            System.out.println(e.descripcion());

        }
        System.out.println("--------------------------------------");

        System.out.println("Búsqueda de un Vehículo por tipo coche: ");
        for (Vehiculo e: concesionario1.buscarVehiculos("Coche")) {

            System.out.println(e.descripcion());

        }
        System.out.println("--------------------------------------");

        System.out.println("Precio promedio de los vehículos: " + String.format("%.2f",concesionario1.precioPromedio()));

    }

}
