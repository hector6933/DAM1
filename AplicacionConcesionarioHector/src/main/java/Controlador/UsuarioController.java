package Controlador;

import DAO.ClienteDAO;
import DAO.UsuarioDAO;
import Modelo.Cliente;
import Modelo.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

public final class UsuarioController {

    public static ArrayList<Usuario> verUsuarios() throws SQLException {

        ArrayList<Usuario> usuarios = UsuarioDAO.selectUsuarios();

        if (usuarios.isEmpty()) {

            return null;

        }

        return usuarios;

    }

    public static Integer insertarUsuarios(ArrayList<Usuario> usuarios) throws SQLException {

        int rows = 0;
        for (Usuario e: usuarios) {

            rows += UsuarioDAO.insertUsuario(e);

        }

        return rows;

    }

    public static boolean insertarUsuario(Usuario usuario) throws SQLException {

        return UsuarioDAO.insertUsuario(usuario) != 0;

    }

    public static Integer modificarUsuario(String campoMod, String nuevoValor, String condicionColumna, String condicionValor) throws SQLException {

        return UsuarioDAO.updateUsuario(campoMod,nuevoValor,condicionColumna,condicionValor);

    }

    public static boolean borrarUsuario(Integer id) throws SQLException {

        int rows = UsuarioDAO.deleteUsuario(id);

        return rows != 0;

    }

    public static Integer getIdUsuario(String nombre) throws SQLException {

        for (Usuario e: UsuarioDAO.selectUsuarios()) {

            if (e.getNombre().equals(nombre)) {

                return e.getId();

            }

        }

        return null;

    }

    public static boolean modificarUsuario(Usuario usuario) throws SQLException {

        return UsuarioDAO.updateAllUsuario(usuario) != 0;

    }

}
