package Controlador;

import DAO.ClienteDAO;
import Modelo.Cliente;

import java.sql.SQLException;
import java.util.ArrayList;

public final class ClienteController {

    public static ArrayList<String> verClientes() throws SQLException {

        ArrayList<String> tuplas = new ArrayList<>();

        ArrayList<Cliente> clientes = ClienteDAO.selectClientes();

        if (clientes.isEmpty()) {

            return null;

        }

        for (Cliente e: clientes) {

            tuplas.add(e.toString());

        }

        return tuplas;

    }

    public static ArrayList<String> verDnis() throws SQLException {

        return ClienteDAO.selectDni();

    }

    public static Integer insertarClientes(ArrayList<Cliente> clientes) throws SQLException {

        int rows = 0;
        for (Cliente c: clientes) {

            rows += ClienteDAO.insertCliente(c);

        }
        return rows;

    }

    public static boolean borrarCliente(String dni) throws SQLException {

        int rows = ClienteDAO.deleteCliente(dni);

        return rows != 0;

    }

    public static Integer modificarCliente(String campoMod, String nuevoValor, String condicionColumna, String condicionValor) throws SQLException {

        return ClienteDAO.updateCliente(campoMod,nuevoValor,condicionColumna,condicionValor);

    }


}
