package DAO;

import Modelo.Cliente;
import Modelo.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public final class EmpleadoDAO {

    private final static String ERROR = "Error en la conexión con la base de datos !";


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
