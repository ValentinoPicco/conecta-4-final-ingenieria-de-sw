package com.conecta4;

import com.conecta4.games.GameFactory;
import com.conecta4.terminations.Termination;
import com.conecta4.ui.UI;

public class GameController {
    Board board;
    Termination termination;
    GameFactory gameFactory;
    UI ui;
    boolean turn;
    boolean can;

    public GameController(GameFactory gameFactory, int rows, int columns, UI ui) {
        board = new Board(rows, columns);
        this.gameFactory = gameFactory;
        this.ui = ui;
        termination = gameFactory.createTerminationStrategy();
    }

    public void play(){
        while (!termination.endStrategy()) {
            turnTitle();
            ui.show(board.toString()); // hacer el toString
            ui.show("¿En que columna quiere colocar la ficha?");
            int columnInput = ui.intRequest();
            can = canInsert(columnInput);
            while (!can) {
                columnInput = ui.intRequest();
                can = canInsert(columnInput);
            }
            String tokenInput = "asignar desde ui";
            insertToken(columnInput, tokenInput);
            turn = !turn;
        }
        winTitle();
    }

    private void insertToken(int c, String tokenInput){
        int r = searchRow(c);
        if (turn) board.insertToken(r, c, gameFactory.createToken(tokenInput));
        else board.insertToken(r, c, gameFactory.createToken(tokenInput));
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

    private void winTitle(){
        if (turn){
            ui.show("Player 2 Win's");
        } else {
            ui.show("Player 1 Win's");
        }
    }

    private void turnTitle(){
        if (turn){
            ui.show("Le toca al Jugador 2");
        } else {
            ui.show("Le toca al Jugador 1");
        }
    }
}
