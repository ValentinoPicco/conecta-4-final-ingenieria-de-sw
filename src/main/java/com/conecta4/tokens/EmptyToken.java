package com.conecta4.tokens;

public class EmptyToken implements Token{
    @Override
    public String getRepresentation() {
        return " ";
    }

    @Override
    public String getColor() {
        return "No color"; 
    }

    @Override
    public String getForm() {
        return "The void has no form";
    }
}
