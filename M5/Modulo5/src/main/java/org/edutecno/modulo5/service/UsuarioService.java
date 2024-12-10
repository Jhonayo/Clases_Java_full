package org.edutecno.modulo5.service;

import java.util.ArrayList;
import java.util.List;

import org.edutecno.modulo5.model.Usuario;

public class UsuarioService {

  private static final List<Usuario> usuarios = new ArrayList<>();

  //registrar usuarios
  public static void registrarUsuario(String usuario, String password){
    usuarios.add(new Usuario(usuario, password));
  }
}
