package DAO;

import Modelo.Conexion;
import Modelo.Vehiculo;

import java.sql.*;
import java.util.ArrayList;

public final class VehiculoDAO {

    private final static String ERROR = "Error en la conexión con la base de datos !";

    public static ArrayList<Vehiculo> selectVehiculos(){

        ArrayList<Vehiculo> resultados = new ArrayList<>();

        try (Connection conexion = Conexion.conexion()){

            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT v.* FROM vehiculo v");

            while (resultSet.next()) {

                String matricula = resultSet.getString("v.matricula");
                String marca = resultSet.getString("v.marca");
                String modelo = resultSet.getString("v.modelo");
                String tipoCombustible = resultSet.getString("v.tipoCombustible");
                Double precio = resultSet.getDouble("v.precio");
                String dniCliente = resultSet.getString("v.dni_cliente");
                int numEmpleado = resultSet.getInt("v.numEmpleado");

                resultados.add(new Vehiculo(matricula,marca,modelo,tipoCombustible,precio,dniCliente,numEmpleado));

            }


        } catch (SQLException e) {

            System.out.println(ERROR);
            e.printStackTrace();

        }

        return resultados;
    }

    public static Integer insertVehiculo(Vehiculo vehiculo){

        int rows = 0;
        try (Connection conexion = Conexion.conexion()) {

            PreparedStatement preparedStatement = conexion.prepareStatement("INSERT INTO vehiculo VALUES (?,?,?,?,?,?,?)");

            preparedStatement.setString(1,vehiculo.getMatricula());
            preparedStatement.setString(2,vehiculo.getMarca());
            preparedStatement.setString(3,vehiculo.getModelo());
            preparedStatement.setString(4,vehiculo.getTipoCombustible());
            preparedStatement.setDouble(5,vehiculo.getPrecio());
            preparedStatement.setString(6,vehiculo.getDniCliente());
            preparedStatement.setInt(7,vehiculo.getNumEmpleado());

            rows = preparedStatement.executeUpdate();

        } catch (SQLException e) {

            System.out.println(ERROR);
            e.printStackTrace();

        }

        return rows;

    }

    public static ArrayList<String> selectMatricula(){

        ArrayList<String> resultados = new ArrayList<>();

        try (Connection conexion = Conexion.conexion()) {

            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT v.matricula FROM vehiculo v");

            while (resultSet.next()) {

                String matricula = resultSet.getString("v.matricula");

                resultados.add(matricula);

            }


        } catch (SQLException e) {

            System.out.println(ERROR);
            e.printStackTrace();

        }

        return resultados;

    }

    public static Integer deleteVehiculo(String matricula){

        try (Connection conexion = Conexion.conexion()) {

            PreparedStatement preparedStatement = conexion.prepareStatement("DELETE FROM vehiculo WHERE matricula LIKE ?");

            preparedStatement.setString(1,matricula);

            return preparedStatement.executeUpdate();


        } catch (SQLException e) {

            System.out.println(ERROR);
            e.printStackTrace();

        }

        return 0;

    }

}
