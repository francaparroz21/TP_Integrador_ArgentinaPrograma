package com.tp_integrador_argprograma.demo.exceptions;

public class EquipoNoEncontrado extends Exception{
    @Override
    public String getMessage() {
        return "No se encontro ningun equipo en la lista. ";
    }
}
