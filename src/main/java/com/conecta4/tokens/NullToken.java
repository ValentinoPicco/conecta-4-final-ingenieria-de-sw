package com.conecta4.tokens;

public class NullToken implements Token{
    @Override
    public String getRepresentation() {
        return " ";
    }

    @Override
    public String getColor() {
        return "No hay color"; // poner en ingles
    }

    @Override
    public String getForm() {
        return "El vacio no tiene forma"; // poner en ingles
    }
}
