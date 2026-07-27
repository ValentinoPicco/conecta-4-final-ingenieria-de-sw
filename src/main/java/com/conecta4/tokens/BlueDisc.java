package com.conecta4.tokens;

public class BlueDisc implements Token{
    @Override
    public String getRepresentation() {
        return "B●";
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
