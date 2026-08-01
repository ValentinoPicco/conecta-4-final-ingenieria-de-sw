package com.conecta4.tokens;

public class Token {
    private TokenStrategy tokenStrategy;

    public Token(TokenStrategy tokenStrategy){
        this.tokenStrategy = tokenStrategy;
    }

    public String getRepresentation(){
        return tokenStrategy.getRepresentation();
    }
    public String getColor(){
        return tokenStrategy.getColor();
    }

    public String getForm(){
        return tokenStrategy.getForm();
    }
}
