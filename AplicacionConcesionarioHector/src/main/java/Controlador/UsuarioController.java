package Controlador;

import DAO.UsuarioDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public final class UsuarioController {

    public static ArrayList<Integer> verIdsUsuario() throws SQLException {

        return UsuarioDAO.selectNumDeps();

    }

}
