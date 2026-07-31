package com.conecta4.terminations;

import com.conecta4.tokens.Token;

public abstract class Termination {
    protected abstract boolean evaluateLine(Token[][] matrix, int r, int c, int rowDir, int colDir, int n);
    protected abstract int getWinCondition();
    protected abstract boolean allowDiagonals();

    public boolean endStrategy(Token[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int n = getWinCondition();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Token current = matrix[r][c];

                if (current.getRepresentation().equals(" ")) {
                    continue;
                }

                // Horizontal
                if (c + n - 1 < cols && evaluateLine(matrix, r, c, 0, 1, n)) return true;
                
                // Vertical
                if (r + n - 1 < rows && evaluateLine(matrix, r, c, 1, 0, n)) return true;

                // Diagonales
                if (allowDiagonals()) {
                    if (r + n - 1 < rows && c + n - 1 < cols && evaluateLine(matrix, r, c, 1, 1, n)) return true;
                    if (r - n + 1 >= 0 && c + n - 1 < cols && evaluateLine(matrix, r, c, -1, 1, n)) return true;
                }
            }
        }
        return false;
    }
}
