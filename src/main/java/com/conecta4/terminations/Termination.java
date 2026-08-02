package com.conecta4.terminations;

import com.conecta4.tokens.Token;

public class Termination {
    TerminationStrategy terminationStrategy;

    public Termination(TerminationStrategy terminationStrategy){
        this.terminationStrategy = terminationStrategy;
    }

    public boolean end(Token[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Token current = matrix[r][c];

                if (current.getRepresentation().equals(" ")) {
                    continue;
                }

                // Horizontal
                if (c + terminationStrategy.getWinCondition() - 1 < cols && terminationStrategy.evaluateLine(matrix, r, c, 0, 1)) return true;
                
                // Vertical
                if (r + terminationStrategy.getWinCondition() - 1 < rows && terminationStrategy.evaluateLine(matrix, r, c, 1, 0)) return true;

                // Diagonales
                if (terminationStrategy.allowDiagonals()) {
                    if (r + terminationStrategy.getWinCondition() - 1 < rows && c + terminationStrategy.getWinCondition() - 1 < cols && terminationStrategy.evaluateLine(matrix, r, c, 1, 1)) return true;
                    if (r - terminationStrategy.getWinCondition() + 1 >= 0 && c + terminationStrategy.getWinCondition() - 1 < cols && terminationStrategy.evaluateLine(matrix, r, c, -1, 1)) return true;
                }
            }
        }
        return false;
    }
}
