package DAO;

import Config.Conexion;
import Modelo.Cliente;
import Modelo.Departamento;

import java.sql.*;
import java.util.ArrayList;

public final class DepartamentoDAO {

    public static ArrayList<Departamento> selectDepartamentos() throws SQLException {

        ArrayList<Departamento> resultados = new ArrayList<>();

        try (Connection conexion = Conexion.conexion()){

            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT d.* FROM departamento d");

            while (resultSet.next()) {

                Integer numDep = resultSet.getInt("d.numDep");
                String nombre = resultSet.getString("d.nombre");

                resultados.add(new Departamento(numDep,nombre));

            }

        }

        return resultados;
    }

    public static ArrayList<Integer> selectNumDeps() throws SQLException {

        ArrayList<Integer> resultados = new ArrayList<>();

        try (Connection conexion = Conexion.conexion()) {

            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT d.numDep FROM departamento d");

            while (resultSet.next()) {

                int num = resultSet.getInt("d.numDep");

                resultados.add(num);

            }
        }

        return resultados;

    }

    public static Integer insertDepartamento(Departamento departamento) throws SQLException {

        try (Connection conexion = Conexion.conexion()) {

            PreparedStatement preparedStatement = conexion.prepareStatement("INSERT INTO departamento (nombre) VALUES (?)");

            preparedStatement.setString(1,departamento.getNombre());

            return preparedStatement.executeUpdate();

        }

    }

    public static Integer updateDepartamento(String campoMod, String nuevoValor, String condicionColumna, String condicionValor) throws SQLException {

        try (Connection conexion = Conexion.conexion()) {

            PreparedStatement preparedStatement = conexion.prepareStatement("UPDATE departamento SET " + campoMod + " = ? WHERE "+ condicionColumna + " = ?");


            preparedStatement.setString(1,nuevoValor);
            preparedStatement.setString(2,condicionValor);

            return preparedStatement.executeUpdate();

        }

    }

    public static Integer deleteDepartamento(Integer numDep) throws SQLException {

        try (Connection conexion = Conexion.conexion()) {

            PreparedStatement preparedStatement = conexion.prepareStatement("DELETE FROM departamento WHERE numDep LIKE ?");

            preparedStatement.setInt(1,numDep);

            return preparedStatement.executeUpdate();

        }

    }

}
