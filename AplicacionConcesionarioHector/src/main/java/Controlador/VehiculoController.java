package Controlador;

import DAO.ClienteDAO;
import DAO.VehiculoDAO;
import Modelo.Cliente;
import Modelo.Vehiculo;

import java.sql.SQLException;
import java.util.ArrayList;

public final class VehiculoController {

    public static ArrayList<Vehiculo> verVehiculos() throws SQLException {

        ArrayList<Vehiculo> vehiculos = VehiculoDAO.selectVehiculos();

        if (vehiculos.isEmpty()) {

            return null;

        }

        return vehiculos;

    }

    public static Integer insertarVehiculos(ArrayList<Vehiculo> vehiculos) throws SQLException {

        int rows = 0;
        for (Vehiculo v: vehiculos) {

            rows += VehiculoDAO.insertVehiculo(v);

        }

        return rows;

    }

    public static ArrayList<String> verMatricula() throws SQLException {

        return VehiculoDAO.selectMatricula();

    }

    public static boolean borrarVehiculo(String matricula) throws SQLException {

        int rows = VehiculoDAO.deleteVehiculo(matricula);

        return rows != 0;

    }

    public static Integer modificarVehiculos(String campoMod, String nuevoValor, String condicionColumna, String condicionValor) throws SQLException {

        return VehiculoDAO.updateVehiculo(campoMod,nuevoValor,condicionColumna,condicionValor);

    }

}
