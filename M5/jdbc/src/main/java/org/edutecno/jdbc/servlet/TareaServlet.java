package org.edutecno.jdbc.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.edutecno.jdbc.model.Tarea;
import org.edutecno.jdbc.service.TareaService;

@WebServlet("/tareas")
public class TareaServlet extends HttpServlet {

  private final TareaService tareaService = new TareaService();
  private final List<Tarea> tareas = new ArrayList<>();

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String nombre = request.getParameter("nombre");
    String descripcion = request.getParameter("descripcion");
    String fecha = request.getParameter("fecha");

    Tarea tarea = new Tarea();
    tarea.setNombre(nombre);
    tarea.setDescripcion(descripcion);
    tarea.setFecha(LocalDate.parse(fecha));

    try {
      tareaService.agregarTarea(tarea);
    } catch (SQLException e) {
      e.printStackTrace();
      request.setAttribute("error", "error al agregar la tarea");
      request.getRequestDispatcher("/tareas").forward(request, response);
    }
    response.sendRedirect("/tareas.jsp");
  }

}
