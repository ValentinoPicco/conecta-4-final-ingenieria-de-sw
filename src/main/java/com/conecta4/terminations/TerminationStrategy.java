package com.conecta4.terminations;

import com.conecta4.tokens.Token;

public abstract class TerminationStrategy {

    int winCondition;

    protected abstract boolean evaluateLine(Token[][] matrix, int r, int c, int rowDir, int colDir);
    protected abstract boolean allowDiagonals();

    public int getWinCondition(){
        return winCondition;
    }
}
