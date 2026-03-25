package org.Dao;

import org.Modelo.Autor;
import org.Modelo.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AutorDAO {

    private static String errorConexion = "Error al conectarse con la base de datos !!!";

    public static boolean insertarAutor(Autor autor){

        try (Connection conexion = Conexion.conexionBase()){

            PreparedStatement statement = conexion.prepareStatement("INSERT INTO autores (nombre,pais) VALUES (?,?)");

            statement.setString(1,autor.getNombre());
            statement.setString(2,autor.getPais());
            int num = statement.executeUpdate();

            return num != 0;

        } catch (Exception e) {

            System.out.println(errorConexion);
            e.printStackTrace();
            return false;

        }

    }

    public static String verAutoresConLibros(){

        StringBuilder resultados = new StringBuilder();

        try (Connection conexion = Conexion.conexionBase()){

            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT a.*, l.* FROM autores a LEFT JOIN libros l ON a.id=l.id_autor");

            while (resultSet.next()) {

                int idAutor = resultSet.getInt("a.id");
                String nombreAutor = resultSet.getString("a.nombre");
                String paisAutor = resultSet.getString("a.pais");

                int idLibro = resultSet.getInt("l.id");
                String tituloLibro = resultSet.getString("l.titulo");
                Double precioLibro = resultSet.getDouble("l.precio");
                int id_autor = resultSet.getInt("l.id_autor");

                resultados.append("Autor: {" + idAutor + " " +  nombreAutor + " " + paisAutor + "} Libro: {" + idLibro + " " + tituloLibro + " " + precioLibro + " " + id_autor +"}");
                resultados.append("\n");

            }

        } catch (Exception e) {

            System.out.println(errorConexion);
            e.printStackTrace();

        }
        return resultados.toString();
    }


    public static ArrayList<Autor> verAutores(){

        ArrayList<Autor> autores = new ArrayList<>();

        try (Connection conexion = Conexion.conexionBase()){

            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT a.* FROM autores a");

            while (resultSet.next()) {

                int id = resultSet.getInt("a.id");
                String nombre = resultSet.getString("a.nombre");
                String pais = resultSet.getString("a.pais");

                autores.add(new Autor(id,nombre,pais));

            }

        } catch (Exception e) {
            System.out.println(errorConexion);
            e.printStackTrace();
        }

        return autores;

    }

    public static ArrayList<Autor> verAutores(String sql){

        ArrayList<Autor> autores = new ArrayList<>();

        try (Connection conexion = Conexion.conexionBase()){

            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                int id = resultSet.getInt("a.id");
                String nombre = resultSet.getString("a.nombre");
                String pais = resultSet.getString("a.pais");

                autores.add(new Autor(id,nombre,pais));

            }

        } catch (Exception e) {
            System.out.println(errorConexion);
            e.printStackTrace();
        }

        return autores;

    }


    public static Integer alterarAutores(String reemplazo, String sql){

        try (Connection conexion = Conexion.conexionBase()) {

            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1,reemplazo);
            System.out.println(preparedStatement);
            int rows = preparedStatement.executeUpdate();
            return rows;

        } catch (Exception e) {

            System.out.println(errorConexion);
            e.printStackTrace();
            return null;

        }

    }

    public static Integer alterarAutores(String condicion,String reemplazo, String sql){

        try (Connection conexion = Conexion.conexionBase()) {

            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1,reemplazo);
            preparedStatement.setString(2,condicion);
            System.out.println(preparedStatement);
            int rows = preparedStatement.executeUpdate();
            return rows;

        } catch (Exception e) {

            System.out.println(errorConexion);
            e.printStackTrace();
            return null;

        }

    }


}
