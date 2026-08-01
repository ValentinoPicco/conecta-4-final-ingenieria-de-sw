package com.conecta4.tokens;

public class RedSquare implements TokenStrategy{
    @Override
    public String getRepresentation() {
        return "RS";
    }

    @Override
    public String getColor() {
        return "Red";
    }

    @Override
    public String getForm() {
        return "Square";
    }
}
