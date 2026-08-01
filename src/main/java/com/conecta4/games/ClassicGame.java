package com.conecta4.games;

import java.util.LinkedList;

import com.conecta4.terminations.FourColorsTerminationStrategy;
import com.conecta4.terminations.Termination;
import com.conecta4.tokens.BlueToken;
import com.conecta4.tokens.RedToken;
import com.conecta4.tokens.Token;


/*
* Version "clásica" del Conecta 4,
* cada jugador tiene un color 
* y gana quien acomode 4 fichas al lado
* de manera horizontal, vertical o diagonal
*/
public class ClassicGame extends GameFactory{
    public ClassicGame(){
        super.p1Options = new LinkedList<>();
        p1Options.add("B");
        super.p2Options = new LinkedList<>();
        p2Options.add("R");
    }

    @Override
    public Termination createTermination() {
        return new Termination(new FourColorsTerminationStrategy());
    }

    @Override
    public Token createToken(String representation) {
        if (representation.equals("R")) return new Token(new RedToken());
        else if (representation.equals("B")) return new Token(new BlueToken());
        else throw new IllegalArgumentException();
    }
}