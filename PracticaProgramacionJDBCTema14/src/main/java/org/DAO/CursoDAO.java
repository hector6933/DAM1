package org.DAO;

import org.Modelo.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public final class CursoDAO {

    private static final String error = "Error en la comunicación con la base de datos !!!";

    private CursoDAO() {
    }

    public static ArrayList<Integer> devolverIds() {

        ArrayList<Integer> ids = new ArrayList<>();

        try (Connection conexion = Conexion.conexion()) {

            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT c.id FROM cursos c");

            while (resultSet.next()) {

                int id = resultSet.getInt("c.id");

                ids.add(id);

            }


        } catch (SQLException e) {

            System.out.println(error);
            e.printStackTrace();

        }

        return ids;

    }

    public static String devolverNombreCurso(Integer id) {

        String resultado = null;

        try (Connection conexion = Conexion.conexion()) {

            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT c.nombre FROM cursos c WHERE id = " + id);

            while (resultSet.next()) {

                resultado = resultSet.getString("c.nombre");

            }


        } catch (SQLException e) {

            System.out.println(error);
            e.printStackTrace();

        }

        return resultado;

    }


}
