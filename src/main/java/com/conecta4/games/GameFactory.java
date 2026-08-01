package com.conecta4.games;

import java.util.List;

import com.conecta4.terminations.Termination;
import com.conecta4.tokens.Token;

public abstract class GameFactory {
    List<String> p1Options;
    List<String> p2Options;

    public abstract Termination createTermination();
    public abstract Token createToken(String representation);

    public List<String> getP1Options(){
        return p1Options;
    }

    public List<String> getP2Options(){
        return p2Options;
    }
}
