Feature: Conecta 4 - Version 3 (4 Colores O 4 Formas)

  Scenario: V3 - Gana con 4 colores iguales horizontal (aunque formas distintas)
    Given Un tablero de 6 filas y 7 columnas con la version "FourColorsOrFourFormsGame"
    And El tablero tiene el estado
      """
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      BD BT BS -  RD RT -
      """
    When Colocamos una ficha "BD" en la columna 4
    Then El juego termina y hay un ganador

  Scenario: V3 - Gana con 4 formas iguales horizontal (aunque colores distintos)
    Given Un tablero de 6 filas y 7 columnas con la version "FourColorsOrFourFormsGame"
    And El tablero tiene el estado
      """
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      BD RD BD -  RT BS -
      """
    When Colocamos una ficha "RD" en la columna 4
    Then El juego termina y hay un ganador

  Scenario: V3 - Gana con 4 colores iguales en vertical
    Given Un tablero de 6 filas y 7 columnas con la version "FourColorsOrFourFormsGame"
    And El tablero tiene el estado
      """
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      RT -  -  -  -  -  -
      RD -  -  -  -  -  -
      RS BD -  -  -  -  -
      """
    When Colocamos una ficha "RT" en la columna 1
    Then El juego termina y hay un ganador

  Scenario: V3 - Gana con 4 formas iguales en diagonal descendente
    Given Un tablero de 6 filas y 7 columnas con la version "FourColorsOrFourFormsGame"
    And El tablero tiene el estado
      """
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      RT -  -  -  -  -  -
      BD RT -  -  -  -  -
      RD BS BT -  -  -  -
      BS RD BD -  -  -  -
      """
    When Colocamos una ficha "BT" en la columna 4
    Then El juego termina y hay un ganador

  Scenario: V3 - No gana si no hay 4 colores ni 4 formas iguales
    Given Un tablero de 6 filas y 7 columnas con la version "FourColorsOrFourFormsGame"
    And El tablero tiene el estado
      """
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      BD RT BS -  -  -  -
      """
    When Colocamos una ficha "RD" en la columna 4
    Then El juego no termina
