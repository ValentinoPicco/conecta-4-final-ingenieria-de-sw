package com.conecta4.terminations;

import com.conecta4.tokens.Token;

public class NTokensNoDiagonalTermination extends Termination{

    public NTokensNoDiagonalTermination(int n) {                                                                      
        super.winCondition = n;                                                                                         
    }
    @Override
    protected boolean evaluateLine(Token[][] matrix, int r, int c, int rowDir, int colDir) {                                                                                                     
        String baseColor = matrix[r][c].getColor();                                                         

        for (int i = 1; i < winCondition; i++) {                                                                       
            if (!baseColor.equals(matrix[r + (i * rowDir)][c + (i * colDir)].getColor())) {                 
                return false;                                                                               
            }                                                                                               
        }                                                                                                   
        return true;                                                                                        
    }                                                                                                                                                                                                            

    @Override
    protected boolean allowDiagonals() {
        return true;
    }
}
