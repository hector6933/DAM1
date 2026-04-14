package Controlador;

import Config.Conexion;
import DAO.EmpleadoDAO;
import Modelo.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public final class EmpleadoController {

    public static ArrayList<String> verEmpleados() throws SQLException {

        ArrayList<String> tuplas = new ArrayList<>();

        for (Empleado e: EmpleadoDAO.selectEmpleados()) {

            tuplas.add(e.toString());

        }

        return tuplas;

    }

    public static boolean borrarEmpleado(Integer numEmp) throws SQLException {

        Integer rows = EmpleadoDAO.deleteEmpleado(numEmp);

        if (rows == 0) {

            return false;

        } else {

            return true;

        }

    }


    public static ArrayList<Integer> verNums(){

        return EmpleadoDAO.selectNum();

    }

}
