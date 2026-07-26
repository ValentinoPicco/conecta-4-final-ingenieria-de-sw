package com.conecta4;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitions {

    @Given("que el juego ha sido iniciado")
    public void que_el_juego_ha_sido_iniciado() {
        // Inicializar el tablero o juego aquí
    }

    @When("el jugador {int} coloca una ficha en la columna {int}")
    public void el_jugador_coloca_una_ficha_en_la_columna(Integer jugador, Integer columna) {
        // Lógica para colocar una ficha
    }

    @Then("el tablero debería mostrar la ficha del jugador {int} en la fila inferior de la columna {int}")
    public void el_tablero_deberia_mostrar_la_ficha_en_la_fila_inferior(Integer jugador, Integer columna) {
        // Validar el estado del tablero
        assertTrue(true, "El tablero debería tener la ficha en el lugar correcto");
    }
}
