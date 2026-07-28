package com.conecta4.games;

import com.conecta4.terminations.Termination;
import com.conecta4.tokens.Token;

public interface GameFactory {
    Termination createTerminationStrategy();
    Token createToken(String representation);
}
