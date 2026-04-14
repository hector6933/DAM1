package DAO;

import Config.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public final class UsuarioDAO {

    public static ArrayList<Integer> selectNumDeps() throws SQLException {

        ArrayList<Integer> resultados = new ArrayList<>();

        try (Connection conexion = Conexion.conexion()) {

            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT u.id FROM usuario u");

            while (resultSet.next()) {

                int num = resultSet.getInt("u.id");

                resultados.add(num);

            }
        }

        return resultados;

    }

}
