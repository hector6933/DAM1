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

    public static ArrayList<String> selectDni(){

        ArrayList<String> resultados = new ArrayList<>();

        try (Connection conexion = Conexion.conexion()){

            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT c.dni FROM cliente c");

            while (resultSet.next()) {

                String dni = resultSet.getString("c.dni");

                resultados.add(dni);

            }

        } catch (SQLException e) {

            System.out.println(ERROR);
            e.printStackTrace();

        }

        return resultados;
    }

    public static Integer insertCliente(Cliente cliente){

        int rows = 0;
        try (Connection conexion = Conexion.conexion()) {

            PreparedStatement preparedStatement = conexion.prepareStatement("INSERT INTO cliente VALUES (?,?,?,?)");

            preparedStatement.setString(1,cliente.getDni());
            preparedStatement.setString(2,cliente.getNombre());
            preparedStatement.setString(3,cliente.getApellidos());
            preparedStatement.setString(4,cliente.getTelefono());

            rows = preparedStatement.executeUpdate();

        } catch (SQLException e) {

            System.out.println(ERROR);
            e.printStackTrace();

        }

        return rows;

    }

    public static Integer deleteCliente(String dni){

        try (Connection conexion = Conexion.conexion()) {

            PreparedStatement preparedStatement = conexion.prepareStatement("DELETE FROM cliente WHERE dni LIKE ?");

            preparedStatement.setString(1,dni);

            return preparedStatement.executeUpdate();


        } catch (SQLException e) {

            System.out.println(ERROR);
            e.printStackTrace();

        }


        return 0;

    }

    public static Integer updateCliente(String campoMod, String nuevoValor, String condicionColumna, String condicionValor){

        try (Connection conexion = Conexion.conexion()) {

            PreparedStatement preparedStatement = conexion.prepareStatement("UPDATE cliente SET " + campoMod + " = ? WHERE "+ condicionColumna + " = ?");


            preparedStatement.setString(1,nuevoValor);
            preparedStatement.setString(2,condicionValor);

            return preparedStatement.executeUpdate();


        } catch (SQLException e) {

            System.out.println(ERROR);
            e.printStackTrace();

        }

        return 0;

    }

}
