package com.conecta4.terminations;

import com.conecta4.tokens.Token;

public class FourFormsTermination extends Termination {

    public FourFormsTermination(){
        super.winCondition = 4;
    }

    @Override
    protected boolean evaluateLine(Token[][] matrix, int r, int c, int rowDir, int colDir) {
        String baseForm = matrix[r][c].getForm();

        for (int i = 1; i < winCondition; i++) {
            String nextForm = matrix[r + (i * rowDir)][c + (i * colDir)].getForm();
            if (!baseForm.equals(nextForm)) {
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
