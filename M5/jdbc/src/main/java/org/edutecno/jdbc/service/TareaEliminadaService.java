package org.edutecno.jdbc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.edutecno.jdbc.model.TareaEliminadas;
import org.edutecno.jdbc.util.DatabaseConnection;

public class TareaEliminadaService {

  public void agregarTareaEliminada(TareaEliminadas tareaEliminadas) throws SQLException {
    String sql = "INSERT INTO tareaseliminadas (id_tarea, nombre_tarea, descripcion_tarea, fecha_tarea, usuario_killer, motivo_eliminacion) values(?,?,?,?,?,?)";
  try(Connection connection = DatabaseConnection.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)){


    }
  }

}
