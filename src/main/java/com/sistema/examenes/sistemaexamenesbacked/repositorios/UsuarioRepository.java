package com.sistema.examenes.sistemaexamenesbacked.repositorios;

import com.sistema.examenes.sistemaexamenesbacked.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByUsername(String username);


}
