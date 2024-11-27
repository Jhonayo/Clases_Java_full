package org.edutecno.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.edutecno.model.CategoriaEnum;
import org.edutecno.model.Cliente;
import org.edutecno.service.ClienteServicio;

public class Menu {
  ClienteServicio clienteServicio = new ClienteServicio();
  Scanner sc = new Scanner(System.in);

  public void iniciarMenu() {
    List<String> opcionMenu = new ArrayList<>();
    opcionMenu.add("Listar Cliente");
    opcionMenu.add("Agregar Cliente");
    opcionMenu.add("Editar CLiente");
    opcionMenu.add("Salir");

    Menu menu = new Menu();
    menu.seleccionMenu(opcionMenu);
  }

  protected int construirMenu(List<String> listaOpcionesMenu) {
    List<String> opcionMenu = listaOpcionesMenu;
    int largo = opcionMenu.size();
    for (int i = 0; i < largo; i++) {
      System.out.println(i + 1 + " " + opcionMenu.get(i));
    }
    int opcion = 0;
    System.out.println("Ingrese una opcion: ");
    try {
      opcion = sc.nextInt();
    } catch (Exception error) {
      sc.nextLine();
    }
    if (opcion < 1 || opcion >= largo + 1) {
      System.out.println("Opcion incorrecta");
    }
    return opcion;
  }

  public void seleccionMenu(List<String> listaOpcionesMenu) {
    boolean continuar = false;
    int resultado;

    do {
      resultado = construirMenu(listaOpcionesMenu);
      switch (resultado) {
        case 1:
          listarCliente();
          break;
        case 2:
          agregarCliente();
          break;
        case 3:
          editarCliente();
          break;
        default:
          System.out.println("opcion no valida");
      }
    } while (!continuar);
  }

  public void listarCliente() {
    clienteServicio.listarClientes();
  }

  public void agregarCliente() {
    System.out.println("Crear Cliente");
    sc.nextLine();
    System.out.println("Ingrese el Run del cliente: ");
    String rutCliente = sc.nextLine();
    System.out.println("Ingrese el nombre del cliente:");
    String nombreCliente = sc.nextLine();
    System.out.println("Ingrese el apellido del cliente:");
    String apellidoCliente = sc.nextLine();
    System.out.println("Ingrese años como cliente: ");
    String aniosCliente = sc.nextLine();

    clienteServicio.agregarCliente(rutCliente, nombreCliente, apellidoCliente, aniosCliente,
        CategoriaEnum.ACTIVO);
  }

  public void editarCliente() {
    System.out.println("Editar Cliente: ");
    System.out.println("Seleccione que desea hacer: ");
    System.out.println("1.- Cambiar estado de la categoria del cliente");
    System.out.println("2.- Editar los datos del cliente");
    int opcionEditar = sc.nextInt();
    System.out.println("Ingrese el run del cliente");
    String runEditar = sc.nextLine();

    List<Cliente> listaClientes = clienteServicio.getListaClientes();

    for (Cliente cliente : listaClientes) {
      if (cliente.getRunCliente().equals(runEditar)) {
        if (opcionEditar == 1) {
          actualizarEstadoCliente(cliente);
        } else {
          actualizarDatosCliente(cliente);
        }
      }
    }

  }

  private void actualizarEstadoCliente(Cliente cliente) {
    System.out.println("El estado actual es: " + cliente.getNombreCliente());
    System.out.println("1.- Cambiar estado");
    System.out.println("2.- Mantener estado");
    System.out.println("Ingrese una opcion");
    int opcionActualizarEstado = sc.nextInt();
    sc.nextLine();
    if (opcionActualizarEstado == 1) {
      // TODO mejorar la aplicacion del metodo para determinar si el cliente esta
      // activo o inactivo y cambiarlo por el contrario
      cliente.setNombreCategoria(CategoriaEnum.INACTIVO);
    } else if (opcionActualizarEstado == 2) {
      System.out.println("No se realizaron cambios");
    } else {
      System.out.println("Opcion invalida");
    }
  }

  private void actualizarDatosCliente(Cliente cliente) {
    System.out.println("¿Que dato del cliente desea modificar?");
    System.out.println("1.- Run");
    System.out.println("2.- Nombre");
    System.out.println("3.- apellido");
    System.out.println("4.- años cliente");

    int opcionActualizarDatosCliente = sc.nextInt();
    sc.nextLine();

    switch (opcionActualizarDatosCliente) {
      case 1:
        System.out.println("Ingrese el nuevo run del cliente");
        String nuevoRunCliente = sc.nextLine();
        cliente.setRunCliente(nuevoRunCliente);
        break;
      case 2:
        System.out.println("Ingrese el nuevo nombre del cliente");
        String nuevoNombreCliente = sc.nextLine();
        cliente.setNombreCliente(nuevoNombreCliente);
        break;
      case 3:
        System.out.println("Ingrese el nuevo apellido del cliente");
        String nuevoApellidoCliente = sc.nextLine();
        cliente.setApellidoCliente(nuevoApellidoCliente);
        break;
      case 4:
        System.out.println("Ingrese la nueva cantidad de años del cliente");
        String nuevoAniosCliente = sc.nextLine();
        cliente.setAniosCliente(nuevoAniosCliente);
        break;

      default:
      System.out.println("La opcion seleccionada es invalida");
    }

  }
}
