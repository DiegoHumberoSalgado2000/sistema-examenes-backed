package com.sistema.examenes.sistemaexamenesbacked.excepciones;

public class UsuarioFoundException extends Exception{

    public UsuarioFoundException(){
        super("El usuario con ese nombre ya existe en la base de datos , vuelva a intertar");
    }

    public UsuarioFoundException(String mensaje){
        super(mensaje);
    }
}
