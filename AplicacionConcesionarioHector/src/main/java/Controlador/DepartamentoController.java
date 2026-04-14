package Controlador;

import DAO.DepartamentoDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public final class DepartamentoController {

    public static ArrayList<Integer> verNumDeps() throws SQLException {

        return DepartamentoDAO.selectNumDeps();

    }

}
