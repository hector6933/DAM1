package tiendaLibros.Controlador;

import tiendaLibros.DAO.AutorDAO;
import tiendaLibros.Modelo.Autor;

import java.sql.SQLException;

public final class AutorController {

    private AutorController(){

    }

    public static boolean insertarAutores(Autor autor) throws SQLException {

        int rows = AutorDAO.insertarAutor(autor);

        return rows != 0;

    }


}
