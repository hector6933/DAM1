package tiendaLibros.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Conexion {

    private static String URL = "jdbc:mysql://localhost:3306/tienda_libros";
    private static String USER = "root";
    private static String PASSWD = "1234";

    private Conexion(){
    }

    public static Connection conexion() throws SQLException {

        return DriverManager.getConnection(URL,USER,PASSWD);

    }

}
