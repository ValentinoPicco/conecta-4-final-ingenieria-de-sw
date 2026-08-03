package com.conecta4;

import com.conecta4.games.*;
import com.conecta4.tokens.Token;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {

    private GameState gameState;
    private GameFactory gameFactory;
    private Board board;

    // ===================================================================
    // GIVEN
    // ===================================================================

    @Given("Un tablero de {int} filas y {int} columnas con la version {string}")
    public void un_tablero_con_version(int rows, int cols, String version) {
        board = new Board(rows, cols);
        gameFactory = createFactory(version);
        gameState = new GameState(board, gameFactory, 4);
    }

    @Given("Un tablero de {int} filas y {int} columnas con la version {string} y N igual a {int}")
    public void un_tablero_con_version_y_n(int rows, int cols, String version, int n) {
        board = new Board(rows, cols);
        gameFactory = createFactory(version);
        gameState = new GameState(board, gameFactory, n);
    }

    @Given("El tablero tiene el estado")
    public void el_tablero_tiene_el_estado(String boardState) {
        loadBoard(boardState);
    }

    // ===================================================================
    // WHEN
    // ===================================================================

    @When("Colocamos una ficha {string} en la columna {int}")
    public void colocamos_una_ficha_en_la_columna(String tokenRep, int column) {
        int c = column - 1; // Convertir a base 0
        gameState.insertToken(c, tokenRep);
    }

    // ===================================================================
    // THEN
    // ===================================================================

    @Then("El juego termina y hay un ganador")
    public void el_juego_termina_y_hay_un_ganador() {
        assertFalse(gameState.inGame(), "El juego debería haber terminado con un ganador");
    }

    @Then("El juego no termina")
    public void el_juego_no_termina() {
        assertTrue(gameState.inGame(), "El juego no debería haber terminado aún");
    }

    @Then("El tablero tiene el estado final")
    public void el_tablero_tiene_el_estado_final(String expectedState) {
        String[][] expected = parseBoard(expectedState);
        Token[][] actual = gameState.getBoard();

        for (int r = 0; r < expected.length; r++) {
            for (int c = 0; c < expected[r].length; c++) {
                String expectedRep = expected[r][c];
                String actualRep = actual[r][c].getRepresentation();

                if (expectedRep.equals("-")) {
                    assertEquals(" ", actualRep,
                        String.format("En fila %d, columna %d se esperaba vacío pero se encontró '%s'", r+1, c+1, actualRep));
                } else {
                    assertEquals(expectedRep, actualRep,
                        String.format("En fila %d, columna %d se esperaba '%s' pero se encontró '%s'", r+1, c+1, expectedRep, actualRep));
                }
            }
        }
    }

    @Then("No se puede insertar en la columna {int}")
    public void no_se_puede_insertar_en_la_columna(int column) {
        int c = column - 1; // Convertir a base 0
        assertFalse(gameState.canInsert(c),
            String.format("No debería poder insertar en la columna %d", column));
    }

    private GameFactory createFactory(String version) {
        return switch (version) {
            case "ClassicGame" -> new ClassicGame();
            case "FourFormsGame" -> new FourFormsGame();
            case "FourColorsOrFourFormsGame" -> new FourColorsOrFourFormsGame();
            case "NColorsAndFormsGame" -> new NColorsAndFormsGame();
            case "NColorsAndFormsNoDiagonalGame" -> new NColorsAndFormsNoDiagonalGame();
            default -> throw new IllegalArgumentException("Versión desconocida: " + version);
        };
    }

    private String[][] parseBoard(String boardText) {
        String[] lines = boardText.trim().split("\n");
        String[][] result = new String[lines.length][];

        for (int i = 0; i < lines.length; i++) {
            result[i] = lines[i].trim().split("\\s+");
        }
        return result;
    }

    private void loadBoard(String boardText) {
        String[][] parsed = parseBoard(boardText);
        Token[][] matrix = board.getBoard();

        for (int r = 0; r < parsed.length; r++) {
            for (int c = 0; c < parsed[r].length; c++) {
                String rep = parsed[r][c];
                if (!rep.equals("-")) {
                    matrix[r][c] = gameFactory.createToken(rep);
                }
            }
        }
    }
}
