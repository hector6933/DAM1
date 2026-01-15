import java.util.ArrayList;

public class demoVehiculos {

    public static void main(String[] args) {

        ArrayList<Vehiculo>misVehiculos = new ArrayList<>();

//        Coche coche1 = new Coche("33","Samsumg");
//
//        Motocicleta moto1 = new Motocicleta("250","Logitech");
//
//        Coche coche2 = new Coche("35i295035","Nike");

        misVehiculos.add(new Coche("33","Samsumg"));
        misVehiculos.add(new Motocicleta("250","Logitech"));
        misVehiculos.add(new Coche("35i295035","Nike"));

        ((Coche) misVehiculos.get(0)).abrirMaletero();

        ((Motocicleta) misVehiculos.get(1)).hacerCaballito();

        for (Vehiculo v : misVehiculos) {

            if (v instanceof Coche) {

                ((Coche) v).abrirMaletero();

            } else if (v instanceof Motocicleta) {

                ((Motocicleta) v).hacerCaballito();

            }

        }

    }

}
