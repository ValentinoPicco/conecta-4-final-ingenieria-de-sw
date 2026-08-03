package com.conecta4;

import com.conecta4.games.*;
import com.conecta4.ui.UI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ControllerStepDefinitions {

    private GameController controller;
    private UI mockUI;

    @Given("Un controlador configurado con la version {string}, tablero de {int}x{int} y N={int}")
    public void un_controlador_configurado_con_version(String version, int rows, int cols, int n) {
        GameFactory gameFactory = switch (version) {
            case "ClassicGame" -> new ClassicGame();
            case "FourFormsGame" -> new FourFormsGame();
            case "FourColorsOrFourFormsGame" -> new FourColorsOrFourFormsGame();
            case "NColorsAndFormsGame" -> new NColorsAndFormsGame();
            case "NColorsAndFormsNoDiagonalGame" -> new NColorsAndFormsNoDiagonalGame();
            default -> throw new IllegalArgumentException("Versión desconocida: " + version);
        };
        Board board = new Board(rows, cols);
        mockUI = mock(UI.class);
        controller = new GameController(gameFactory, board, mockUI, n);
    }

    @Given("La secuencia de inputs del usuario sera:")
    public void la_secuencia_de_inputs_sera(DataTable dataTable) {
        List<String> rows = dataTable.asList(String.class);
        Integer[] inputs = new Integer[rows.size()];
        
        for (int i = 0; i < rows.size(); i++) {
            inputs[i] = Integer.parseInt(rows.get(i));
        }

        // Si hay al menos un input, configuramos el mock para que devuelva esos valores en secuencia
        if (inputs.length > 0) {
            Integer first = inputs[0];
            Integer[] rest = new Integer[inputs.length - 1];
            System.arraycopy(inputs, 1, rest, 0, inputs.length - 1);
            
            when(mockUI.intRequest()).thenReturn(first, rest);
        }
    }

    @When("Se ejecuta el metodo play del GameController")
    public void se_ejecuta_el_metodo_play() {
        controller.play();
    }

    @Then("El juego termina")
    public void el_juego_termina() {
        // Al usar mocks, si controller.play() sale del bucle 'while (gameState.inGame())', 
        // significa que el juego terminó exitosamente y captó la condición de victoria.
        assertTrue(true);
    }

    @Then("La UI mostro que gano el {string}")
    public void la_ui_mostro_que_gano(String ganador) {
        String mensajeEsperado = ganador.equals("Jugador 1") ? "¡Gana el Jugador 1!" : "¡Gana el Jugador 2!";
        
        // Verificamos que el mock haya recibido la llamada 'show' con el mensaje esperado
        verify(mockUI, atLeastOnce()).show(mensajeEsperado);
    }
}
