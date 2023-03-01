package com.sistema.examenes.sistemaexamenesbacked.servicios.Impl;

import com.sistema.examenes.sistemaexamenesbacked.excepciones.UsuarioFoundException;
import com.sistema.examenes.sistemaexamenesbacked.modelo.Usuario;
import com.sistema.examenes.sistemaexamenesbacked.modelo.UsuarioRol;
import com.sistema.examenes.sistemaexamenesbacked.repositorios.RolRepository;
import com.sistema.examenes.sistemaexamenesbacked.repositorios.UsuarioRepository;
import com.sistema.examenes.sistemaexamenesbacked.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UsuarioServicelmp implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;


    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal=usuarioRepository.findByUsername(usuario.getUsername());
        if (usuarioLocal!=null){ //validacion que se encarga de que el usuario ya esta registrado
            System.out.println("El usuario ya existe");
            throw new UsuarioFoundException("El usuario ya esat presente");
        }else{ //si no existe el suaurio se guardara con el rol asignado
            for (UsuarioRol usuarioRol: usuarioRoles){
                rolRepository.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles); //agrega toda la informacion en el objeto de usuario
            usuarioLocal=usuarioRepository.save(usuario); //se guarda el objeto usuario
        }
        return usuarioLocal;  //retorna el usuario local
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }


}
