package DAO;

import Config.Conexion;
import Modelo.Cliente;
import Modelo.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public final class EmpleadoDAO {

    private final static String ERROR = "Error en la conexión con la base de datos !";

    public static ArrayList<Empleado> selectEmpleados() throws SQLException{

        ArrayList<Empleado> resultados = new ArrayList<>();

        try (Connection conexion = Conexion.conexion()){

            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT e.* FROM empleado e");

            while (resultSet.next()) {

                Integer numEmpleado = resultSet.getInt("e.numEmpleado");
                String nombre = resultSet.getString("e.nombre");
                String apellidos = resultSet.getString("e.apellidos");
                String telefono = String.valueOf(resultSet.getInt("e.telefono"));
                Date fechaNacimiento = resultSet.getDate("e.fechaNacimiento");
                Integer numGerente = resultSet.getInt("e.numGerente");
                Integer numDep = resultSet.getInt("e.numDep");
                Integer id_usuario = resultSet.getInt("e.id_usuario");

                resultados.add(new Empleado(numEmpleado,nombre,apellidos,telefono,fechaNacimiento,numGerente,numDep,id_usuario));

            }

        }

        return resultados;

    }

    public static Integer deleteEmpleado(Integer numEmp) throws SQLException {

        try (Connection conexion = Conexion.conexion()) {

            PreparedStatement preparedStatement = conexion.prepareStatement("DELETE FROM empleado WHERE numEmpleado LIKE ?");

            preparedStatement.setInt(1,numEmp);

            return preparedStatement.executeUpdate();

        }

    }

    public static ArrayList<Integer> selectNum(){

        ArrayList<Integer> resultados = new ArrayList<>();

        try (Connection conexion = Conexion.conexion()) {

            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT e.numEmpleado FROM empleado e");

            while (resultSet.next()) {

                int num = resultSet.getInt("e.numEmpleado");

                resultados.add(num);

            }

        } catch (SQLException e) {

            System.out.println(ERROR);
            e.printStackTrace();

        }

        return resultados;

    }

}
