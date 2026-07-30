package com.conecta4.tokens;

public class RedTriangule implements Token{
    @Override
    public String getRepresentation() {
        return "RT";
    }

    @Override
    public String getColor() {
        return "Red";
    }

    @Override
    public String getForm() {
        return "Triangule";
    }
}
