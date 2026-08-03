Feature: Conecta 4 - Version 1 (4 Colores)

  # ============================================================
  # VICTORIA HORIZONTAL
  # ============================================================

  Scenario: V1 - Gana con 4 colores iguales en linea horizontal
    Given Un tablero de 6 filas y 7 columnas con la version "ClassicGame"
    And El tablero tiene el estado
      """
      - - - - - - -
      - - - - - - -
      - - - - - - -
      - - - - - - -
      - - - - - - -
      R R R - B B -
      """
    When Colocamos una ficha "R" en la columna 4
    Then El juego termina y hay un ganador
    And El tablero tiene el estado final
      """
      - - - - - - -
      - - - - - - -
      - - - - - - -
      - - - - - - -
      - - - - - - -
      R R R R B B -
      """

  # ============================================================
  # VICTORIA VERTICAL
  # ============================================================

  Scenario: V1 - Gana con 4 colores iguales en linea vertical
    Given Un tablero de 6 filas y 7 columnas con la version "ClassicGame"
    And El tablero tiene el estado
      """
      - - - - - - -
      - - - - - - -
      - - - - - - -
      B - - - - - -
      B - - - - - -
      B - R R R - -
      """
    When Colocamos una ficha "B" en la columna 1
    Then El juego termina y hay un ganador
    And El tablero tiene el estado final
      """
      - - - - - - -
      - - - - - - -
      B - - - - - -
      B - - - - - -
      B - - - - - -
      B - R R R - -
      """

  # ============================================================
  # VICTORIA DIAGONAL DESCENDENTE
  # ============================================================

  Scenario: V1 - Gana con 4 colores iguales en diagonal descendente
    Given Un tablero de 6 filas y 7 columnas con la version "ClassicGame"
    And El tablero tiene el estado
      """
      - - - - - - -
      - - - - - - -
      R - - - - - -
      B R - - - - -
      B B R - - - -
      B R B - R - -
      """
    When Colocamos una ficha "R" en la columna 4
    Then El juego termina y hay un ganador
    And El tablero tiene el estado final
      """
      - - - - - - -
      - - - - - - -
      R - - - - - -
      B R - - - - -
      B B R - - - -
      B R B R R - -
      """

  # ============================================================
  # VICTORIA DIAGONAL ASCENDENTE
  # ============================================================

  Scenario: V1 - Gana con 4 colores iguales en diagonal ascendente
    Given Un tablero de 6 filas y 7 columnas con la version "ClassicGame"
    And El tablero tiene el estado
      """
      - - - - - - -
      - - - - - - -
      - - - R - - -
      - - R B - - -
      - R B B - - -
      - B R B - - -
      """
    When Colocamos una ficha "R" en la columna 1
    Then El juego termina y hay un ganador
    And El tablero tiene el estado final
      """
      - - - - - - -
      - - - - - - -
      - - - R - - -
      - - R B - - -
      - R B B - - -
      R B R B - - -
      """

  # ============================================================
  # NO HAY GANADOR AUN
  # ============================================================

  Scenario: V1 - No hay ganador aun si no se alinean 4 del mismo color
    Given Un tablero de 6 filas y 7 columnas con la version "ClassicGame"
    And El tablero tiene el estado
      """
      - - - - - - -
      - - - - - - -
      - - - - - - -
      - - - - - - -
      - - - - - - -
      R R - B B - -
      """
    When Colocamos una ficha "R" en la columna 4
    Then El juego no termina

  # ============================================================
  # TABLERO VACIO
  # ============================================================

  Scenario: V1 - Tablero vacio no tiene ganador
    Given Un tablero de 6 filas y 7 columnas con la version "ClassicGame"
    And El tablero tiene el estado
      """
      - - - - - - -
      - - - - - - -
      - - - - - - -
      - - - - - - -
      - - - - - - -
      - - - - - - -
      """
    When Colocamos una ficha "R" en la columna 1
    Then El juego no termina
