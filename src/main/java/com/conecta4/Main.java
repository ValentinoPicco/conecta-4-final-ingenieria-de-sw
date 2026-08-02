package com.conecta4;

import java.util.Scanner;

import com.conecta4.games.ClassicGame;
import com.conecta4.games.FourColorsOrFourFormsGame;
import com.conecta4.games.FourFormsGame;
import com.conecta4.games.NColorsAndFormsGame;
import com.conecta4.games.NColorsAndFormsNoDiagonalGame;
import com.conecta4.ui.*;

public class Main {
    public static void main(String[] args) {
        int rows;
        int columns;
        int op;
        int n;
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
            1. Conecta 4 Clasico\n
            2. Conecta 4 Formas\n
            3. Conecta 4 Colores o Formas\n
            4. Conecta N Colores y Formas\n
            5. Conecta N Colores y Formas (SIN DIAGONALES)\n
            """);
            op = ui.intRequest();
            switch (op) {
                case 1:
                    gameController = new GameController(new ClassicGame(), new Board(rows, columns), ui, -1);
                    start = true;
                    break;
                case 2:
                    gameController = new GameController(new FourFormsGame(), new Board(rows, columns), ui, -1);
                    start = true;
                    break;
                case 3:
                    gameController = new GameController(new FourColorsOrFourFormsGame(), new Board(rows, columns), ui, -1);
                    start = true;
                    break;
                case 4:
                    ui.show("Designe un valor para N (mayor o igual a 2)");
                    n = ui.intRequest();
                    gameController = new GameController(new NColorsAndFormsGame(), new Board(rows, columns), ui, n);
                    start = true;
                    break;
                case 5:
                    ui.show("Designe un valor para N (mayor o igual a 2)");
                    n = ui.intRequest();
                    gameController = new GameController(new NColorsAndFormsNoDiagonalGame(), new Board(rows, columns), ui, n);
                    start = true;
                    break;
                default:
                    ui.show("Elija una opcion válida");
                    break;
            }
        } while (!start);

        gameController.play();

        scanner.close();
    }

}