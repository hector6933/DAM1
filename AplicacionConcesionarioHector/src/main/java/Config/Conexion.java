package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Conexion {

    private static final String RUTA_BASE_DE_DATOS = "jdbc:mysql://localhost:3306/ConcesionarioHector";
    private static final String USUARIO_BASE = "root";
    private static final String PASSWD_BASE = "1234";

    private Conexion() {
    }

    public static Connection conexion() throws SQLException {

        return DriverManager.getConnection(RUTA_BASE_DE_DATOS,USUARIO_BASE,PASSWD_BASE);

    }

}

