package com.conecta4.tokens;

public class BlueSquare implements Token{
    @Override
    public String getRepresentation() {
        return "BS";
    }

    @Override
    public String getColor() {
        return "Blue";
    }

    @Override
    public String getForm() {
        return "Square";
    }
}
