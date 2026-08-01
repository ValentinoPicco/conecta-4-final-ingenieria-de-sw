package com.conecta4.tokens;

public class BlueDisc implements TokenStrategy{
    @Override
    public String getRepresentation() {
        return "BD";
    }

    @Override
    public String getColor() {
        return "Blue";
    }

    @Override
    public String getForm() {
        return "Disc";
    }
}
