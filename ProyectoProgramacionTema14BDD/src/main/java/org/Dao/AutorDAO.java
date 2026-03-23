package org.Dao;

import org.Modelo.Autor;
import org.Modelo.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AutorDAO {

    public static boolean insertarAutor(Autor autor){

        try (Connection conexion = Conexion.conexionBase()){

            PreparedStatement statement = conexion.prepareStatement("INSERT INTO autores (nombre,pais) VALUES (?,?)");

            statement.setString(1,autor.getNombre());
            statement.setString(2,autor.getPais());
            int num = statement.executeUpdate();

            return num != 0;

        } catch (Exception e) {

            System.out.println("Error al insertar el autor");
            e.printStackTrace();
            return false;

        }

    }

    public static void verAutoresConLibros(){

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

                System.out.println(idAutor + " " +  nombreAutor + " " + paisAutor + " " + idLibro + " " + tituloLibro + " " + precioLibro + " " + id_autor);

            }

        } catch (Exception e) {

            System.out.println("Error al ver los autores");
            e.printStackTrace();

        }

    }

}
