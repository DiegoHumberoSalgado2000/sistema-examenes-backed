package com.sistema.examenes.sistemaexamenesbacked;

import com.sistema.examenes.sistemaexamenesbacked.excepciones.UsuarioFoundException;
import com.sistema.examenes.sistemaexamenesbacked.modelo.Rol;
import com.sistema.examenes.sistemaexamenesbacked.modelo.Usuario;
import com.sistema.examenes.sistemaexamenesbacked.modelo.UsuarioRol;
import com.sistema.examenes.sistemaexamenesbacked.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SistemaExamenesBackedApplication implements CommandLineRunner {
    @Autowired
	private UsuarioService usuarioService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SistemaExamenesBackedApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*try {

			Usuario usuario=new Usuario();

			usuario.setNombre("Diego");
			usuario.setApellido("Salgado");
			usuario.setUsername("Diego200");
			usuario.setPassword(bCryptPasswordEncoder.encode("123456789"));
			usuario.setEmail("diego@gmail.com");
			usuario.setTelefono("315489761");
			usuario.setPerfil("foto.png");

			Rol rol=new Rol();

			rol.setId(1L);
			rol.setNombre("Admin");

			Set<UsuarioRol> usuarioRoles=new HashSet<>();
			UsuarioRol usuarioRol=new UsuarioRol();

			usuarioRol.setRol(rol);
			usuarioRol.setUsuario(usuario);
			usuarioRoles.add(usuarioRol);

			Usuario usuarioGuardado=usuarioService.guardarUsuario(usuario,usuarioRoles);
			System.out.println(usuarioGuardado.getUsername());


		}catch (UsuarioFoundException exception){
             exception.printStackTrace();
		}*/
	}
}
