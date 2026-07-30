package com.conecta4;

import com.conecta4.tokens.EmptyToken;
import com.conecta4.tokens.Token;

public class Board {
    private Token[][] board;
    private int rows, columns;

    public Board(int r, int c){
        rows = r;
        columns = c;
        board = new Token[rows][columns];
        initialize();
    }

    private void initialize(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = new EmptyToken();
            }
        }
    }

    public void insertToken(int r, int c, Token token){
        board[r][c] = token;
    }

    public Token[][] getBoard() {
        return board;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
