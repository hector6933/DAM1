package Clases;

import java.util.ArrayList;

public class Concesionario {

    private ArrayList<Vehiculo> vehiculos;

    public Concesionario(){

        vehiculos = new ArrayList<>();

    }

    public Concesionario(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Double precioPromedio(){

        if (vehiculos.isEmpty()) {

            return null;

        } else {

            Double total = 0.0;
            for (Vehiculo e: vehiculos) {

                total += e.getPrecio();

            }
            return total/vehiculos.size();

        }

    }

    public ArrayList<Vehiculo> buscarVehiculos(String input) {

        ArrayList<Vehiculo> resultado = new ArrayList<>();

        if (vehiculos.isEmpty()) {

            return null;


        } else {

            for (Vehiculo e: vehiculos) {

                if (e.getMarca().equalsIgnoreCase(input)) {

                    resultado.add(e);

                }
                if (input.equalsIgnoreCase("Coche")) {

                    if (e instanceof Coche) {

                        resultado.add(e);

                    }

                }
                if (input.equalsIgnoreCase("Motocicleta")) {

                    if (e instanceof Motocicleta) {

                        resultado.add(e);

                    }

                }
                if (input.equalsIgnoreCase("Camion")) {

                    if (e instanceof Camion) {

                        resultado.add(e);

                    }

                }

            }

            return resultado;

        }

    }

    public Vehiculo vehiculoMasAntiguo(){

        if (vehiculos.isEmpty()) {

            return null;

        } else {
            Vehiculo temp = vehiculos.getFirst();
            for (Vehiculo e: vehiculos) {

                if (e.calcularAntiguedad() > temp.calcularAntiguedad()) {

                    temp = e;

                }

            }

            return temp;

        }

    }

    public void mostrarVehiculos(){

        if (vehiculos.isEmpty()) {

            System.out.println("No hay vehículos que mostrar");

        } else {

            for (Vehiculo e: vehiculos) {

                System.out.println(e.descripcion());

            }

        }

    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
}
