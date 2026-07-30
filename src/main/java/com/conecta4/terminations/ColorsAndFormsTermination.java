package com.conecta4.terminations;

import com.conecta4.tokens.Token;

public class ColorsAndFormsTermination extends Termination {

    @Override
    protected boolean evaluateLine(Token[][] matrix, int r, int c, int rowDir, int colDir, int n) {
        String baseColor = matrix[r][c].getColor();
        String baseForm = matrix[r][c].getForm();
        
        boolean colorValid = baseColor != null && !baseColor.trim().isEmpty();
        boolean formValid = baseForm != null && !baseForm.trim().isEmpty();

        boolean allSameColor = colorValid;
        boolean allSameForm = formValid;

        for (int i = 1; i < n; i++) {
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
    protected int getWinCondition() {
        return 4;
    }

    @Override
    protected boolean allowDiagonals() {
        return true;
    }
}
