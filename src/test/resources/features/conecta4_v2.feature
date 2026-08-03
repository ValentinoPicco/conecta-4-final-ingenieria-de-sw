Feature: Conecta 4 - Version 2 (4 Formas)

  Scenario: V2 - Gana con 4 formas iguales en horizontal (discos)
    Given Un tablero de 6 filas y 7 columnas con la version "FourFormsGame"
    And El tablero tiene el estado
      """
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      BD RD BD -  RT RT -
      """
    When Colocamos una ficha "RD" en la columna 4
    Then El juego termina y hay un ganador
    And El tablero tiene el estado final
      """
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      BD RD BD RD RT RT -
      """

  Scenario: V2 - Gana con 4 formas iguales en vertical (triangulos)
    Given Un tablero de 6 filas y 7 columnas con la version "FourFormsGame"
    And El tablero tiene el estado
      """
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      RT -  -  -  -  -  -
      BT -  -  -  -  -  -
      RT BD -  -  -  -  -
      """
    When Colocamos una ficha "BT" en la columna 1
    Then El juego termina y hay un ganador

  Scenario: V2 - Gana con 4 formas iguales en diagonal descendente
    Given Un tablero de 6 filas y 7 columnas con la version "FourFormsGame"
    And El tablero tiene el estado
      """
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      BS -  -  -  -  -  -
      RD BS -  -  -  -  -
      BD RT RS -  -  -  -
      RT BD RD -  -  -  -
      """
    When Colocamos una ficha "BS" en la columna 4
    Then El juego termina y hay un ganador

  Scenario: V2 - Gana con 4 formas iguales en diagonal ascendente
    Given Un tablero de 6 filas y 7 columnas con la version "FourFormsGame"
    And El tablero tiene el estado
      """
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  RS -  -  -
      -  -  RS BD -  -  -
      -  RS BD RT -  -  -
      -  BD RD BD -  -  -
      """
    When Colocamos una ficha "BS" en la columna 1
    Then El juego termina y hay un ganador

  Scenario: V2 - No gana con 4 colores iguales pero formas distintas
    Given Un tablero de 6 filas y 7 columnas con la version "FourFormsGame"
    And El tablero tiene el estado
      """
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      -  -  -  -  -  -  -
      BD BT BS -  RD -  -
      """
    When Colocamos una ficha "BD" en la columna 4
    Then El juego no termina
