package Controlador;

import DAO.ClienteDAO;
import DAO.VehiculoDAO;
import Modelo.Cliente;
import Modelo.Vehiculo;

import java.util.ArrayList;

public final class VehiculoController {

    public static ArrayList<String> verVehiculos(){

        ArrayList<String> tuplas = new ArrayList<>();

        ArrayList<Vehiculo> vehiculos = VehiculoDAO.selectVehiculos();

        if (vehiculos.isEmpty()) {

            return null;

        }

        for (Vehiculo e: vehiculos) {

            tuplas.add(e.toString());

        }

        return tuplas;

    }

    public static Integer insertarVehiculos(ArrayList<Vehiculo> vehiculos){

        int rows = 0;
        for (Vehiculo v: vehiculos) {

            rows += VehiculoDAO.insertVehiculo(v);

        }

        return rows;

    }

    public static ArrayList<String> verMatricula(){

        return VehiculoDAO.selectMatricula();

    }

    public static boolean borrarVehiculo(String matricula) {

        int rows = VehiculoDAO.deleteVehiculo(matricula);

        return rows != 0;

    }

}
