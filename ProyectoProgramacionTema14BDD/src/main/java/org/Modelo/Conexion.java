package org.Modelo;

import java.sql.*;

public final class Conexion {

    private Conexion() {
    }

    public static Connection conexionBase() throws SQLException {

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda_libros","root","1234");


    }

}
