package com.conecta4;

import com.conecta4.tokens.NullToken;
import com.conecta4.tokens.Token;

public class Board {
    private static Board instance;
    private Token[][] board;
    private int rows, columns;

    private Board(){
        rows = 6;
        columns = 8;
        board = new Token[rows][columns];
        initialize();
    }

    public static Board getInstance(){
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }

    private void initialize(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = new NullToken();
            }
        }
    }
}
