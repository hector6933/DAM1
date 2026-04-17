package Controlador;

import DAO.ClienteDAO;
import DAO.DepartamentoDAO;
import DAO.VehiculoDAO;
import Modelo.Departamento;
import Modelo.Vehiculo;

import java.sql.SQLException;
import java.util.ArrayList;

public final class DepartamentoController {

    public static ArrayList<Departamento> verDepartamentos() throws SQLException {

        ArrayList<Departamento> departamentos = DepartamentoDAO.selectDepartamentos();

        if (departamentos.isEmpty()) {

            return null;

        }

        return departamentos;

    }

    public static Integer insertarDepartamentos(ArrayList<Departamento> departamentos) throws SQLException {

        int rows = 0;
        for (Departamento e: departamentos) {

            rows += DepartamentoDAO.insertDepartamento(e);

        }

        return rows;

    }

    public static Integer modificarDepartamento(String campoMod, String nuevoValor, String condicionColumna, String condicionValor) throws SQLException {

        return DepartamentoDAO.updateDepartamento(campoMod,nuevoValor,condicionColumna,condicionValor);

    }

    public static boolean borrarDepartamento(Integer numDep) throws SQLException {

        int rows = DepartamentoDAO.deleteDepartamento(numDep);

        return rows != 0;

    }

    public static ArrayList<Integer> verNumDeps() throws SQLException {

        return DepartamentoDAO.selectNumDeps();

    }

}
