package com.tp_integrador_argprograma.demo;

public class PartidoNoEncontrado extends Exception{
    @Override
    public String getMessage() {
        return "No se encontro ningun partido en la lista. ";
    }
}
