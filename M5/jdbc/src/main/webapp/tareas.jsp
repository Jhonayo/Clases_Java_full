<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
  <html>

    <head>
      <title>Gestion de tarea</title>
   </head>

    <body>
      <h1>Gestion de tarea</h1>
      <br />
      <form method="post" action="/tareas">
        <label for="nombre">Nombre</label>
        <input type="text" id="nombre" name="nombre" required>
        <br><br>
        <label for="descripcion">Descipcion</label>
        <input type="text" id="descripcion" name="descripcion" required>
        <br><br>
        <label for="fecha">Fecha</label>
        <input type="date" id="fecha" name="fecha" required>
        <br><br>
        <button type="submit">Agregar tarea</button>

      </form>
    </body>
  </html>
