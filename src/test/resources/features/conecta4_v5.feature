Feature: Conecta 4 - Version 5 (N Colores Y Formas SIN diagonales)

  Scenario: V5 - Gana con 3 en linea horizontal (N=3, sin diagonales)
    Given Un tablero de 6 filas y 7 columnas con la version "NColorsAndFormsNoDiagonalGame" y N igual a 3
    And El tablero tiene el estado
      """
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      BD BD -  RD RD -  -
      """
    When Colocamos una ficha "BD" en la columna 3
    Then El juego termina y hay un ganador

  Scenario: V5 - Gana con 3 en linea vertical (N=3, sin diagonales)
    Given Un tablero de 6 filas y 7 columnas con la version "NColorsAndFormsNoDiagonalGame" y N igual a 3
    And El tablero tiene el estado
      """
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      RD -  -  -  -  -  -
      RD BD -  -  -  -  -
      """
    When Colocamos una ficha "RD" en la columna 1
    Then El juego termina y hay un ganador

  Scenario: V5 - NO gana con 3 en diagonal aunque esten alineadas (N=3, sin diagonales)
    Given Un tablero de 6 filas y 7 columnas con la version "NColorsAndFormsNoDiagonalGame" y N igual a 3
    And El tablero tiene el estado
      """
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  BD -  -  -  -
      -  BD RT -  -  -  -
      RD RS BT -  -  -  -
      """
    When Colocamos una ficha "BD" en la columna 1
    Then El juego no termina

  Scenario: V5 - NO gana con diagonal descendente (N=3, sin diagonales)
    Given Un tablero de 6 filas y 7 columnas con la version "NColorsAndFormsNoDiagonalGame" y N igual a 3
    And El tablero tiene el estado
      """
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      BD BS -  -  -  -  -
      RD RT -  -  -  -  -
      """
    When Colocamos una ficha "BS" en la columna 3
    Then El juego no termina
