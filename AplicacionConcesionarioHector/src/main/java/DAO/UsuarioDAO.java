package DAO;

import Config.Conexion;
import Modelo.Departamento;
import Modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;

public final class UsuarioDAO {

    public static ArrayList<Usuario> selectUsuarios() throws SQLException {

        ArrayList<Usuario> resultados = new ArrayList<>();

        try (Connection conexion = Conexion.conexion()){

            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT u.* FROM usuario u");

            while (resultSet.next()) {

                Integer id = resultSet.getInt("u.id");
                String nombre = resultSet.getString("u.nombre");
                String passwd = resultSet.getString("u.passwd");
                String rol = resultSet.getString("u.rol");

                resultados.add(new Usuario(id,nombre,passwd,rol));

            }

        }

        return resultados;
    }

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

    public static Integer insertUsuario(Usuario usuario) throws SQLException {

        try (Connection conexion = Conexion.conexion()) {

            PreparedStatement preparedStatement = conexion.prepareStatement("INSERT INTO usuario (nombre,passwd,rol) VALUES (?,?,?)");

            preparedStatement.setString(1,usuario.getNombre());
            preparedStatement.setString(2,usuario.getPasswd());
            preparedStatement.setString(3,usuario.getRol());

            return preparedStatement.executeUpdate();

        }

    }

    public static Integer updateUsuario(String campoMod, String nuevoValor, String condicionColumna, String condicionValor) throws SQLException {

        try (Connection conexion = Conexion.conexion()) {

            PreparedStatement preparedStatement = conexion.prepareStatement("UPDATE usuario SET " + campoMod + " = ? WHERE "+ condicionColumna + " = ?");


            preparedStatement.setString(1,nuevoValor);
            preparedStatement.setString(2,condicionValor);

            return preparedStatement.executeUpdate();

        }

    }

    public static Integer deleteUsuario(Integer id) throws SQLException {

        try (Connection conexion = Conexion.conexion()) {

            PreparedStatement preparedStatement = conexion.prepareStatement("DELETE FROM usuario WHERE id LIKE ?");

            preparedStatement.setInt(1,id);

            return preparedStatement.executeUpdate();

        }

    }

}
