Feature: Flujo completo del GameController

  Scenario: Partida clasica completa donde gana el Jugador 1 con una columna vertical
    Given Un controlador configurado con la version "ClassicGame", tablero de 6x7 y N=4
    And La secuencia de inputs del usuario sera:
      | 0 |
      | 8 |
      | 1 |
      | 0 |
      | 9 |
      | 1 |
      | 2 |
      | 1 |
      | 1 |
      | 1 |
      | 2 |
      | 1 |
      | 1 |
      | 1 |
      | 2 |
      | 1 |
      | 1 |
      | 1 |
    When Se ejecuta el metodo play del GameController
    Then El juego termina
    And La UI mostro que gano el "Jugador 1"
