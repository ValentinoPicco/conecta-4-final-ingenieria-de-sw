package com.conecta4;

import com.conecta4.games.GameFactory;
import com.conecta4.terminations.Termination;
import com.conecta4.tokens.EmptyToken;

public class GameController {
    Board board;
    Termination termination;
    GameFactory gameFactory;
    boolean turn;
    boolean can;

    public GameController(GameFactory gameFactory, int rows, int columns) {
        board = new Board(rows, columns);
        this.gameFactory = gameFactory;
        termination = gameFactory.createTerminationStrategy();
    }

    // cambiar todos los 0 por la columna que se pida
    public void play(){
        // func diciendo que empieza player 1
        while (!termination.endStrategy()) {
            // mostrar tablero
            // pedir columna
            can = canInsert(0);
            while (!can) {
                // pedir columna nuevamente
                can = canInsert(0);
            }
            insertToken(0, turn);
            turn = !turn;
        }
        winTitle();
    }

    private void insertToken(int c, boolean turn){
        int r = searchRow(c);
        if (turn) board.insertToken(r, c, gameFactory.createToken("B")); // cambiar este if para que se adapte a todos los token
        else board.insertToken(r, c, gameFactory.createToken("R"));
    }

    private int searchRow(int c){
        int i = 0;
        while (i < board.getRows() && !board.getBoard()[i][c].getRepresentation().equals(" ")) {
            i++;
        }
        return i - 1;
    }

    private boolean canInsert(int c){
        if (c >= board.getColumns() || c < 1) // No se puede insertar una ficha fuera del tablero
            return false;
        if (!board.getBoard()[0][c].getRepresentation().equals(" ")) // No se puede insertar una ficha en una columna llena
            return false;
        return true;
    }

    // esto va en ui
    private void winTitle(){
        if (turn){
            System.out.println("Player 2 Win's");
        } else {
            System.out.println("Player 1 Win's");
        }
    }
}
