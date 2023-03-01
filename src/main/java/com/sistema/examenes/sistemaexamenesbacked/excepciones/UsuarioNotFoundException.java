package com.sistema.examenes.sistemaexamenesbacked.excepciones;

public class UsuarioNotFoundException extends Exception{

    public UsuarioNotFoundException(){
        super("El usuario con ese nombre no existe en la base de datos");
    }

    public UsuarioNotFoundException(String mensaje){
        super(mensaje);
    }
}
