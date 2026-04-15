package DAO;

import Modelo.Cliente;
import Config.Conexion;

import java.sql.*;
import java.util.ArrayList;

public final class ClienteDAO {

    private final static String ERROR = "Error en la conexión con la base de datos !";

    public static ArrayList<Cliente> selectClientes() throws SQLException {

        ArrayList<Cliente> resultados = new ArrayList<>();

        try (Connection conexion = Conexion.conexion()){

            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT c.* FROM cliente c");

            while (resultSet.next()) {

                String dni = resultSet.getString("c.dni");
                String nombre = resultSet.getString("c.nombre");
                String apellidos = resultSet.getString("c.apellidos");
                String telefono = resultSet.getString("c.telefono");

                resultados.add(new Cliente(dni,nombre,apellidos,telefono));

            }

        }

        return resultados;
    }

    public static ArrayList<String> selectDni() throws SQLException {

        ArrayList<String> resultados = new ArrayList<>();

        try (Connection conexion = Conexion.conexion()){

            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT c.dni FROM cliente c");

            while (resultSet.next()) {

                String dni = resultSet.getString("c.dni");

                resultados.add(dni);

            }

        }

        return resultados;
    }

    public static Integer insertCliente(Cliente cliente) throws SQLException {

        try (Connection conexion = Conexion.conexion()) {

            PreparedStatement preparedStatement = conexion.prepareStatement("INSERT INTO cliente VALUES (?,?,?,?)");

            preparedStatement.setString(1,cliente.getDni());
            preparedStatement.setString(2,cliente.getNombre());
            preparedStatement.setString(3,cliente.getApellidos());
            preparedStatement.setString(4,cliente.getTelefono());

            return preparedStatement.executeUpdate();

        }

    }

    public static Integer deleteCliente(String dni) throws SQLException {

        try (Connection conexion = Conexion.conexion()) {

            PreparedStatement preparedStatement = conexion.prepareStatement("DELETE FROM cliente WHERE dni LIKE ?");

            preparedStatement.setString(1,dni);

            return preparedStatement.executeUpdate();


        }

    }

    public static Integer updateCliente(String campoMod, String nuevoValor, String condicionColumna, String condicionValor) throws SQLException {

        try (Connection conexion = Conexion.conexion()) {

            PreparedStatement preparedStatement = conexion.prepareStatement("UPDATE cliente SET " + campoMod + " = ? WHERE "+ condicionColumna + " = ?");


            preparedStatement.setString(1,nuevoValor);
            preparedStatement.setString(2,condicionValor);

            return preparedStatement.executeUpdate();

        }

    }

}
