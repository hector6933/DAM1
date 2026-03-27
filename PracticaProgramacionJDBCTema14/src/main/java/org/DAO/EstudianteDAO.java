package org.DAO;

import org.Modelo.Conexion;
import org.Modelo.Estudiante;

import java.sql.*;
import java.util.ArrayList;

public final class EstudianteDAO {

    private static final String error = "Error en la comunicación con la base de datos !!!";

    private EstudianteDAO() {
    }

     public static ArrayList<Estudiante> selectEstudiantes(){

        ArrayList<Estudiante> resultados = new ArrayList<>();

        try (Connection conexion = Conexion.conexion()) {

            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT e.* FROM estudiantes e");

            while (resultSet.next()) {

                int id = resultSet.getInt("e.id");
                String nombre = resultSet.getString("e.nombre");
                int edad = resultSet.getInt("e.edad");
                int idCurso = resultSet.getInt("e.id_curso");

                resultados.add(new Estudiante(id,nombre,edad,idCurso));

            }

        } catch (SQLException e) {

            System.out.println(error);
            e.printStackTrace();

        }

        return resultados;

     }

     public static Integer insertEstudiante(Estudiante es){

        try (Connection conexion = Conexion.conexion()) {

            PreparedStatement preparedStatement = conexion.prepareStatement("INSERT INTO estudiantes (nombre,edad,id_curso) VALUES (?,?,?)");

            preparedStatement.setString(1,es.getNombre());
            preparedStatement.setInt(2,es.getEdad());
            preparedStatement.setInt(3,es.getCurso());

            return preparedStatement.executeUpdate();

        } catch (SQLException e) {

            System.out.println(error);
            e.printStackTrace();

        }
         return 0;

     }

     public static ArrayList<Integer> devolverIdsEstudiante(){

        ArrayList<Integer> idsEstudiantes = new ArrayList<>();

        try (Connection conexion = Conexion.conexion()) {

            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT e.id FROM estudiantes e");

            while (resultSet.next()) {

                idsEstudiantes.add(resultSet.getInt("e.id"));

            }

        } catch (SQLException e) {

            System.out.println(error);
            e.printStackTrace();

        }

        return idsEstudiantes;

     }

     public static Integer updateEstudiantesEdadId(Integer id, Integer edad){

        try (Connection conexion = Conexion.conexion()) {

            PreparedStatement preparedStatement = conexion.prepareStatement("UPDATE estudiantes SET edad = " + edad + " WHERE id = " + id);

            return preparedStatement.executeUpdate();

        } catch (SQLException e) {

            System.out.println(error);
            e.printStackTrace();

        }
        return null;
     }

    public static Integer updateEstudiantesEdadNombre(String nombre, Integer edad){

        try (Connection conexion = Conexion.conexion()) {

            PreparedStatement preparedStatement = conexion.prepareStatement("UPDATE estudiantes SET edad = " + edad + " WHERE nombre = ?");

            preparedStatement.setString(1,nombre);

            return preparedStatement.executeUpdate();

        } catch (SQLException e) {

            System.out.println(error);
            e.printStackTrace();

        }
        return 0;
    }

    public static Integer updateEstudiantesEdadCurso(Integer curso, Integer edad){

        try (Connection conexion = Conexion.conexion()) {

            PreparedStatement preparedStatement = conexion.prepareStatement("UPDATE estudiantes SET edad = " + edad + " WHERE id_curso = " + curso);

            return preparedStatement.executeUpdate();

        } catch (SQLException e) {

            System.out.println(error);
            e.printStackTrace();

        }
        return 0;
    }

    public static Integer eliminarEstudiantePorId(Integer id){

        try (Connection conexion = Conexion.conexion()) {

            PreparedStatement preparedStatement = conexion.prepareStatement("DELETE FROM estudiantes WHERE id = " + id);

            return preparedStatement.executeUpdate();

        } catch (SQLException e) {

            System.out.println(error);
            e.printStackTrace();

        }
        return 0;
    }


}
