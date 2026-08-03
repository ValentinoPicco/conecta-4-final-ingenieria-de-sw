Feature: Conecta 4 - Board y GameState

  Scenario: Una ficha cae al fondo del tablero por gravedad
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
    When Colocamos una ficha "R" en la columna 3
    Then El tablero tiene el estado final
      """
      - - - - - - -
      - - - - - - -
      - - - - - - -
      - - - - - - -
      - - - - - - -
      - - R - - - -
      """

  Scenario: Las fichas se apilan correctamente
    Given Un tablero de 6 filas y 7 columnas con la version "ClassicGame"
    And El tablero tiene el estado
      """
      - - - - - - -
      - - - - - - -
      - - - - - - -
      - - - - - - -
      - - - - - - -
      - - R - - - -
      """
    When Colocamos una ficha "B" en la columna 3
    Then El tablero tiene el estado final
      """
      - - - - - - -
      - - - - - - -
      - - - - - - -
      - - - - - - -
      - - B - - - -
      - - R - - - -
      """

  Scenario: No se puede insertar en una columna fuera de rango
    Given Un tablero de 6 filas y 7 columnas con la version "ClassicGame"
    Then No se puede insertar en la columna 0
    And No se puede insertar en la columna 8
    And No se puede insertar en la columna -1

  Scenario: No se puede insertar en una columna llena
    Given Un tablero de 6 filas y 7 columnas con la version "ClassicGame"
    And El tablero tiene el estado
      """
      R - - - - - -
      B - - - - - -
      R - - - - - -
      B - - - - - -
      R - - - - - -
      B - - - - - -
      """
    Then No se puede insertar en la columna 1
