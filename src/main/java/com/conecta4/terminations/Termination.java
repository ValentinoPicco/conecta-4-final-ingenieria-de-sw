package com.conecta4.terminations;

import com.conecta4.tokens.Token;

public abstract class Termination {

    int winCondition;

    protected abstract boolean evaluateLine(Token[][] matrix, int r, int c, int rowDir, int colDir);
    protected abstract boolean allowDiagonals();

    public boolean endStrategy(Token[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Token current = matrix[r][c];

                if (current.getRepresentation().equals(" ")) {
                    continue;
                }

                // Horizontal
                if (c + winCondition - 1 < cols && evaluateLine(matrix, r, c, 0, 1)) return true;
                
                // Vertical
                if (r + winCondition - 1 < rows && evaluateLine(matrix, r, c, 1, 0)) return true;

                // Diagonales
                if (allowDiagonals()) {
                    if (r + winCondition - 1 < rows && c + winCondition - 1 < cols && evaluateLine(matrix, r, c, 1, 1)) return true;
                    if (r - winCondition + 1 >= 0 && c + winCondition - 1 < cols && evaluateLine(matrix, r, c, -1, 1)) return true;
                }
            }
        }
        return false;
    }
}
