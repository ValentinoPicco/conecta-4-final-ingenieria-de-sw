package com.conecta4;

import com.conecta4.games.GameFactory;
import com.conecta4.ui.UI;
import java.util.List;

public class GameController {
    private GameState gameState;
    private UI ui;

    public GameController(GameFactory gameFactory, Board board, UI ui, int n) {
        gameState = new GameState(board, gameFactory, n);
        this.ui = ui;
    }

    public void play(){
        while (gameState.inGame()) {
            ui.showBoard(gameState.getBoard());
            turnTitle();
            int columnInput = initTurn();
            boolean can = gameState.canInsert(columnInput);
            while (!can) {
                ui.show("Seleccione una columna válida");
                columnInput = ui.intRequest() - 1;
                can = gameState.canInsert(columnInput);
            }
            ui.show("Seleccione una ficha:");
            List<String> options = gameState.getCurrentPlayerOptions();
            ui.showList(options);
            int tokenIndex = ui.intRequest();
            while (tokenIndex < 1 || tokenIndex > options.size()) {
                ui.show("Seleccione una ficha válida");
                ui.showList(options);
                tokenIndex = ui.intRequest();
            }
            String tokenInput = options.get(tokenIndex - 1);
            
            gameState.insertToken(columnInput, tokenInput);
            gameState.switchTurn();
        }
        ui.showBoard(gameState.getBoard());
        winTitle();
    }

    private void winTitle(){
        if (gameState.getTurn()){
            ui.show("Player 1 Win's");
        } else {
            ui.show("Player 2 Win's");
        }
    }

    private void turnTitle(){
        if (gameState.getTurn()){
            ui.show("Le toca al Jugador 2");
        } else {
            ui.show("Le toca al Jugador 1");
        }
    }

    private int initTurn(){
        ui.show("¿En que columna quiere colocar la ficha?");
        return ui.intRequest() - 1;
    }


}
