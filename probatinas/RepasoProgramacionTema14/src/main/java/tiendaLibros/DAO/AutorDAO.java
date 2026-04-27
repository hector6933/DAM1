package tiendaLibros.DAO;

import tiendaLibros.Config.Conexion;
import tiendaLibros.Modelo.Autor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class AutorDAO {

    private static final String ERROR = "¡¡¡ Error en la conexión con la base de datos !!!";

    private AutorDAO(){
    }

    public static Integer insertarAutor(Autor autor) throws SQLException {

        Connection conexion = Conexion.conexion();

        PreparedStatement preparedStatement = conexion.prepareStatement("INSERT INTO autores (nombre,pais) VALUES (?,?)");

        preparedStatement.setString(1,autor.getNombre());
        preparedStatement.setString(2,autor.getPais());

        return preparedStatement.executeUpdate();

    }


}
