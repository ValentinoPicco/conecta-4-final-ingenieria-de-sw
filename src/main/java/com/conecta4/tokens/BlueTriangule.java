package com.conecta4.tokens;

public class BlueTriangule implements TokenStrategy{
    @Override
    public String getRepresentation() {
        return "BT";
    }

    @Override
    public String getColor() {
        return "Blue";
    }

    @Override
    public String getForm() {
        return "Triangule";
    }
}
