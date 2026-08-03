Feature: Conecta 4 - Version 4 (N Colores Y Formas con diagonales)

  Scenario: V4 - Gana con 3 en linea horizontal (N=3)
    Given Un tablero de 6 filas y 7 columnas con la version "NColorsAndFormsGame" y N igual a 3
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

  Scenario: V4 - Gana con 5 en linea vertical (N=5)
    Given Un tablero de 6 filas y 7 columnas con la version "NColorsAndFormsGame" y N igual a 5
    And El tablero tiene el estado
      """
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      RD -  -  -  -  -  -
      RD -  -  -  -  -  -
      RD -  -  -  -  -  -
      RD BD BD -  -  -  -
      """
    When Colocamos una ficha "RD" en la columna 1
    Then El juego termina y hay un ganador

  Scenario: V4 - Gana con 3 en diagonal descendente (N=3)
    Given Un tablero de 6 filas y 7 columnas con la version "NColorsAndFormsGame" y N igual a 3
    And El tablero tiene el estado
      """
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      RD BS -  -  -  -  -
      RT RS BS -  -  -  -
      """
    When Colocamos una ficha "BS" en la columna 1
    Then El juego termina y hay un ganador

  Scenario: V4 - Gana con 3 en diagonal ascendente (N=3)
    Given Un tablero de 6 filas y 7 columnas con la version "NColorsAndFormsGame" y N igual a 3
    And El tablero tiene el estado
      """
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  BT -  -  -  -
      -  BT RT -  -  -  -
      -  RD RS -  -  -  -
      """
    When Colocamos una ficha "BT" en la columna 1
    Then El juego termina y hay un ganador

  Scenario: V4 - No gana con 3 en linea si N es 4
    Given Un tablero de 6 filas y 7 columnas con la version "NColorsAndFormsGame" y N igual a 4
    And El tablero tiene el estado
      """
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      BD BD BD -  RD -  -
      """
    When Colocamos una ficha "RT" en la columna 4
    Then El juego no termina
