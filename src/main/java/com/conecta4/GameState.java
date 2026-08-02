package com.conecta4;

import java.util.List;

import com.conecta4.games.GameFactory;
import com.conecta4.terminations.Termination;
import com.conecta4.tokens.Token;

public class GameState {
    private Board board;
    private Termination termination;
    private GameFactory gameFactory;
    private boolean turn;

    public GameState(Board board, GameFactory gameFactory){
        this.board = board;
        this.gameFactory = gameFactory;
        termination = gameFactory.createTermination();
        turn = false;
    }

    public void switchTurn(){
        turn = !turn;
    }

    public List<String> getCurrentPlayerOptions(){
        if (turn){
            return gameFactory.getP2Options();
        } else {
            return gameFactory.getP1Options();
        }
    }

    public boolean inGame(){
        return !termination.end(board.getBoard());
    }

    public boolean getTurn(){
        return turn;
    }

    public Token[][] getBoard(){
        return board.getBoard();
    }

    public void insertToken(int c, String token){
        int r = searchRow(c);
        board.insertToken(r, c, gameFactory.createToken(token));
    }

    public boolean canInsert(int c){
        return board.canInsert(c);
    }

    private int searchRow(int c){
        for (int i = board.getRows() - 1; i >= 0; i--) {
            if (board.getBoard()[i][c].getRepresentation().equals(" ")) {
                return i;
            }
        }
        return -1;
    }
}
