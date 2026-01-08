import java.util.ArrayList;

public class demoVehiculos {

    public static void main(String[] args) {

        ArrayList<Vehiculo>misVehiculos = new ArrayList<>();

        Coche coche1 = new Coche("33","Samsumg");

        Motocicleta moto1 = new Motocicleta("250","Logitech");

        Coche coche2 = new Coche("35i295035","Nike");

        misVehiculos.add(coche1);
        misVehiculos.add(moto1);
        misVehiculos.add(coche2);

        coche1.abrirMaletero();
        moto1.hacerCaballito();
    }

}
