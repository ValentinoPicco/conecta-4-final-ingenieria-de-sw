package com.conecta4;

import java.util.Scanner;

import com.conecta4.games.ClassicGame;
import com.conecta4.ui.*;

public class Main {
    public static void main(String[] args) {
        int rows;
        int columns;
        int op;
        boolean start = false;
        GameController gameController = null;
        Scanner scanner = new Scanner(System.in);
        UI ui = new ConsoleUI(scanner);

        ui.show("¿Cuántas filas habrá?");
        rows = ui.intRequest();
        ui.show("¿Cuántas columnas habrá?");
        columns = ui.intRequest();
        
        do {
            ui.show("""
            Selecciona un modo de juego:\n
            1. Conecta 4 Clasico
            """);
            op = ui.intRequest();
            switch (op) {
                case 1:
                    gameController = new GameController(new ClassicGame(), rows, columns, ui);
                    start = false;
                    break;
            
                default:
                    break;
            }
        } while (!start);

        gameController.play();

        scanner.close();
    }

}