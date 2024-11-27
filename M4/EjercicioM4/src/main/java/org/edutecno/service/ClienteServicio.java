package org.edutecno.service;

import java.util.ArrayList;
import java.util.List;

import org.edutecno.model.CategoriaEnum;
import org.edutecno.model.Cliente;

public class ClienteServicio {

  List<Cliente> listaClientes;

  public ClienteServicio() {
    listaClientes = new ArrayList<>();
  }

  public void listarClientes() {
    if (listaClientes != null) {
      for (Cliente cliente : listaClientes) {
        System.out.println("--------------------Datos del Cliente----------------------");
        System.out.println("Run " + cliente.getRunCliente());
        System.out.println("Nombre " + cliente.getNombreCliente());
        System.out.println("Apellido " + cliente.getApellidoCliente());
        System.out.println("Años como cliente " + cliente.getAniosCliente());
        System.out.println("Categoria del cliente " + cliente.getNombreCategoria());
        System.out.println("----------------------------------------------------------");
      }
    } else {
      System.out.println("No se han agregados clientes.");
    }
  }

  public void agregarCliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente, CategoriaEnum nombreCategoria) {
    Cliente cliente = new Cliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, nombreCategoria);
    if (listaClientes != null) {
      listaClientes.add(cliente);
    } else {
      System.out.println("El cliente ya existe.");
    }
  }

  public void editarCliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente, CategoriaEnum nombreCategoria) {
  
  }

  public List<Cliente> getListaClientes() {
    return listaClientes;
  }

  public void setListaClientes(List<Cliente> listaClientes) {
    this.listaClientes = listaClientes;
  }

}
