package Controlador;

import Config.Conexion;
import DAO.EmpleadoDAO;
import DAO.UsuarioDAO;
import DAO.VehiculoDAO;
import Modelo.Empleado;
import Modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public final class EmpleadoController {

    public static ArrayList<Empleado> verEmpleados() throws SQLException {

        ArrayList<Empleado> empleados = EmpleadoDAO.selectEmpleados();

        if (empleados.isEmpty()) {

            return null;

        }

        return empleados;

    }

    public static Integer insertarEmpleados(ArrayList<Empleado> empleados) throws SQLException {

        int rows = 0;
        for (Empleado e: empleados) {

            rows += EmpleadoDAO.insertEmpleado(e);

        }

        return rows;

    }

    public static Integer modificarEmpleados(String campoMod, String nuevoValor, String condicionColumna, String condicionValor) throws SQLException {

        return EmpleadoDAO.updateEmpleado(campoMod,nuevoValor,condicionColumna,condicionValor);

    }

    public static boolean borrarEmpleado(Integer numEmp) throws SQLException {

        Integer rows = EmpleadoDAO.deleteEmpleado(numEmp);

        if (rows == 0) {

            return false;

        } else {

            return true;

        }

    }


    public static ArrayList<Integer> verNums() throws SQLException {

        return EmpleadoDAO.selectNum();

    }

}
