Feature: Juego Conecta 4

  Scenario: Iniciar un nuevo juego
    Given que el juego ha sido iniciado
    When el jugador 1 coloca una ficha en la columna 1
    Then el tablero debería mostrar la ficha del jugador 1 en la fila inferior de la columna 1
