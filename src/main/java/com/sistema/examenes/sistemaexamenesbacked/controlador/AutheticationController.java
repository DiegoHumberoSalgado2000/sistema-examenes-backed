package com.sistema.examenes.sistemaexamenesbacked.controlador;

import com.sistema.examenes.sistemaexamenesbacked.configuraciones.JwtUtil;
import com.sistema.examenes.sistemaexamenesbacked.excepciones.UsuarioNotFoundException;
import com.sistema.examenes.sistemaexamenesbacked.modelo.JwtRequest;
import com.sistema.examenes.sistemaexamenesbacked.modelo.JwtResponse;
import com.sistema.examenes.sistemaexamenesbacked.modelo.Usuario;
import com.sistema.examenes.sistemaexamenesbacked.servicios.Impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AutheticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/generate-token")
    public ResponseEntity<?> generartToken(@RequestBody JwtRequest jwtRequest)throws Exception{
     try {
      autenticar(jwtRequest.getUsername(), jwtRequest.getPassword());
     }catch (UsuarioNotFoundException exception){
         exception.printStackTrace();
         throw new Exception("Usuario no encontrado");
     }
     UserDetails userDetails=this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
     String token=this.jwtUtil.generateToken(userDetails);
     return ResponseEntity.ok(new JwtResponse(token));
    }

    private void autenticar(String username, String password)throws Exception{
    try {
     authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
    }catch (DisabledException disabledException){
      throw new Exception("Usuario deshabilitado " + disabledException.getMessage());
    }catch (BadCredentialsException badCredentialsException){
     throw new Exception("Credenciales invalidas " + badCredentialsException.getMessage());
    }
    }

    @GetMapping("/actual-usuario")
    public Usuario obtenerUsuarioActual(Principal principal){
    return (Usuario) this.userDetailsService.loadUserByUsername(principal.getName());
    }
}
