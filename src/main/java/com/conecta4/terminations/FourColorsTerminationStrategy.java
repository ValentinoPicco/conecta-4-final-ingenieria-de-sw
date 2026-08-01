package com.conecta4.terminations;

import com.conecta4.tokens.Token;

public class FourColorsTerminationStrategy extends TerminationStrategy {

    public FourColorsTerminationStrategy(){
        super.winCondition = 4;
    }

    @Override
    protected boolean evaluateLine(Token[][] matrix, int r, int c, int rowDir, int colDir) {
        String baseColor = matrix[r][c].getColor();

        for (int i = 1; i < winCondition; i++) {
            String nextColor = matrix[r + (i * rowDir)][c + (i * colDir)].getColor();
            if (!baseColor.equals(nextColor)) {
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
