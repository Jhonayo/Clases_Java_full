package org.edutecno.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.edutecno.jdbc.util.DatabaseConnection;

public class Main {

  public static void main(String[] args) throws SQLException {
    try (Connection connection = DatabaseConnection.getConnection()) {
      if (connection != null) {
        System.out.println("Coneccion con exito");
      } else {
        System.out.println("Fallo en intento de la coneccion");
      }
    } catch (SQLException e) {
   System.out.println("Error al conectar la base de datos");      e.printStackTrace();
}

  }
}
