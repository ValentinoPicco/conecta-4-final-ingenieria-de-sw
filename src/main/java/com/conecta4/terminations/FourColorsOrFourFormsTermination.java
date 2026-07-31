package com.conecta4.terminations;

import com.conecta4.tokens.Token;

public class FourColorsOrFourFormsTermination extends Termination {

    public FourColorsOrFourFormsTermination(){
        super.winCondition = 4;
    }

    @Override
    protected boolean evaluateLine(Token[][] matrix, int r, int c, int rowDir, int colDir) {
        String baseColor = matrix[r][c].getColor();
        String baseForm = matrix[r][c].getForm();

        boolean allSameColor = true;
        boolean allSameForm = true;

        for (int i = 1; i < winCondition; i++) {
            Token next = matrix[r + (i * rowDir)][c + (i * colDir)];
            
            if (allSameColor && !baseColor.equals(next.getColor())) {
                allSameColor = false;
            }
            if (allSameForm && !baseForm.equals(next.getForm())) {
                allSameForm = false;
            }
        }

        return allSameColor || allSameForm;
    }

    @Override
    protected boolean allowDiagonals() {
        return true;
    }
}
