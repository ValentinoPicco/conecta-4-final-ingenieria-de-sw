package com.conecta4;

import com.conecta4.terminations.Termination;

public class Game {
    Board board;
    Termination termination;
    boolean turn;

    public Game(Board b, Termination t) {
        board = b;
        termination = t;
    }

    public void play(){
        // func diciendo que empieza player 1
        while (!termination.end()) {
            // mostrar tablero
            // jugada
            turn = !turn;
        }
        winTitle();
    }

    private void winTitle(){
        if (turn){
            System.out.println("Player 2 Win's");
        } else {
            System.out.println("Player 1 Win's");
        }
    }
}
