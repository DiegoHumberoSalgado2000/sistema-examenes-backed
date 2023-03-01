package com.sistema.examenes.sistemaexamenesbacked.servicios;

import com.sistema.examenes.sistemaexamenesbacked.modelo.Usuario;
import com.sistema.examenes.sistemaexamenesbacked.modelo.UsuarioRol;

import java.util.Set;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    public Usuario obtenerUsuario(String username);

    public void eliminarUsuario(Long usuarioId);


}
