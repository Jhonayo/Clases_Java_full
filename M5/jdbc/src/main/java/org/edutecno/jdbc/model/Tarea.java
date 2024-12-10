package org.edutecno.jdbc.model;

import java.time.LocalDate;

public class Tarea {

  private int id;
  private String nombre;
  private String descripcion;
  private LocalDate fecha;


  public Tarea() {
  }

  public Tarea(int id, String nombre, String descripccion, LocalDate fecha) {
    this.id = id;
    this.nombre = nombre;
    this.descripcion = descripccion;
    this.fecha = fecha;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }

  @Override
  public String toString() {
    return "Tarea{id=" + id + ", nombre=" + nombre + ", descripccion=" + descripcion + ", fecha=" + fecha + "}";
  }

}
