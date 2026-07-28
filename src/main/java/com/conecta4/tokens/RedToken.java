package com.conecta4.tokens;

public class RedToken implements Token{
    @Override
    public String getRepresentation() {
        return "R";
    }

    @Override
    public String getColor() {
        return "Red";
    }

    @Override
    public String getForm() {
        return "Classic";
    }
}
