# conecta-4-final-ingenieria-de-sw

## Ejercicio 3 — Particionado del espacio de entradas

### Funcionalidad 1: Evaluación de terminación (`Termination.end`)

#### Características y particiones

| Característica (C)          | Bloque 1     | Bloque 2     | Bloque 3              | Bloque 4              | Bloque 5                      |
|-----------------------------|--------------|--------------|------------------------|------------------------|-------------------------------|
| C1: Dirección de alineación | Horizontal   | Vertical     | Diagonal descendente   | Diagonal ascendente    | —                             |
| C2: Versión del juego       | ClassicGame  | FourForms    | FourColorsOrFourForms  | NColorsAndForms (N=3)  | NColorsAndFormsNoDiagonal (N=3) |
| C3: Resultado               | Hay ganador  | No hay ganador | —                    | —                      | —                             |

#### Cobertura de Bloque Base

Se elige como **bloque base**: **(C1: Horizontal, C2: ClassicGame, C3: Hay ganador)**.

| ID   | C1: Dirección          | C2: Versión            | C3: Resultado   | Variación respecto a la base |
|------|------------------------|------------------------|-----------------|-------------------------------|
| TB1  | **Horizontal**         | **ClassicGame**        | **Hay ganador** | — (BASE)                      |
| TB2  | Vertical               | ClassicGame            | Hay ganador     | Cambio en C1                  |
| TB3  | Diagonal descendente   | ClassicGame            | Hay ganador     | Cambio en C1                  |
| TB4  | Diagonal ascendente    | ClassicGame            | Hay ganador     | Cambio en C1                  |
| TB5  | Horizontal             | FourForms              | Hay ganador     | Cambio en C2                  |
| TB6  | Horizontal             | FourColorsOrFourForms  | Hay ganador     | Cambio en C2                  |
| TB7  | Horizontal             | NColorsAndForms (N=3)  | Hay ganador     | Cambio en C2                  |
| TB8  | Horizontal             | NColorsAndFormsNoDiagonal (N=3) | Hay ganador | Cambio en C2                  |
| TB9  | Horizontal             | ClassicGame            | No hay ganador  | Cambio en C3                  |

---

### Funcionalidad 2: Evaluación de terminación con versión sin diagonales (`NColorsAndFormsNoDiagonal`)

Para esta funcionalidad se aplica **cobertura de pares (pair-wise)**, ya que la combinación de la versión "sin diagonales" con la dirección de alineación produce interacciones no triviales que necesitan ser verificadas.

#### Características y particiones

| Característica (C)           | Bloque 1     | Bloque 2     | Bloque 3              | Bloque 4              |
|------------------------------|--------------|--------------|------------------------|------------------------|
| C1: Dirección de alineación  | Horizontal   | Vertical     | Diagonal descendente   | Diagonal ascendente    |
| C2: Versión del juego        | NColorsAndForms (con diag.) | NColorsAndFormsNoDiagonal (sin diag.) | — | — |
| C3: Resultado                | Hay ganador  | No hay ganador | —                    | —                      |

#### Tabla pair-wise

Se deben cubrir **todos los pares posibles** entre cada par de características. La siguiente tabla cubre todos los pares con la mínima cantidad de tests:

| ID   | C1: Dirección         | C2: Versión                     | C3: Resultado   | Pares cubiertos                                                    |
|------|-----------------------|---------------------------------|-----------------|--------------------------------------------------------------------|
| PW1  | Horizontal            | NColorsAndForms                 | Hay ganador     | (C1-C2: Hor,ConDiag), (C1-C3: Hor,Gana), (C2-C3: ConDiag,Gana)   |
| PW2  | Vertical              | NColorsAndFormsNoDiagonal       | Hay ganador     | (C1-C2: Ver,SinDiag), (C1-C3: Ver,Gana), (C2-C3: SinDiag,Gana)   |
| PW3  | Diagonal descendente  | NColorsAndForms                 | Hay ganador     | (C1-C2: DiagD,ConDiag), (C1-C3: DiagD,Gana), (C2-C3: ConDiag,Gana) |
| PW4  | Diagonal ascendente   | NColorsAndForms                 | Hay ganador     | (C1-C2: DiagA,ConDiag), (C1-C3: DiagA,Gana), (C2-C3: ConDiag,Gana) |
| PW5  | Horizontal            | NColorsAndFormsNoDiagonal       | No hay ganador  | (C1-C2: Hor,SinDiag), (C1-C3: Hor,NoGana), (C2-C3: SinDiag,NoGana) |
| PW6  | Diagonal descendente  | NColorsAndFormsNoDiagonal       | No hay ganador  | (C1-C2: DiagD,SinDiag), (C1-C3: DiagD,NoGana), (C2-C3: SinDiag,NoGana) |
| PW7  | Diagonal ascendente   | NColorsAndFormsNoDiagonal       | No hay ganador  | (C1-C2: DiagA,SinDiag), (C1-C3: DiagA,NoGana), (C2-C3: SinDiag,NoGana) |
| PW8  | Vertical              | NColorsAndForms                 | No hay ganador  | (C1-C2: Ver,ConDiag), (C1-C3: Ver,NoGana), (C2-C3: ConDiag,NoGana)    |

#### Requisitos de test irrealizables (Terminación)

| ID   | Combinación                                                  | Razón                                                                                                |
|------|--------------------------------------------------------------|------------------------------------------------------------------------------------------------------|
| TI1  | Diagonal descendente + NColorsAndFormsNoDiagonal + Hay ganador | La versión sin diagonales tiene `allowDiagonals() = false`. El método `Termination.end()` no evalúa diagonales cuando esta bandera es `false`, por lo que es **imposible** ganar por diagonal en esta versión. |
| TI2  | Diagonal ascendente + NColorsAndFormsNoDiagonal + Hay ganador  | Misma razón que TI1: las diagonales ascendentes tampoco se evalúan cuando `allowDiagonals() = false`. |

---

### Mapeo de tests BDD existentes a requisitos de test

Los tests BDD del proyecto cubren los requisitos de las tablas anteriores de la siguiente manera:

#### Bloque Base — Terminación (Funcionalidad 1)

| Requisito | Archivo feature                 | Escenario                                                        |
|-----------|---------------------------------|------------------------------------------------------------------|
| TB1       | `conecta4_v1.feature`           | V1 - Gana con 4 colores iguales en linea horizontal             |
| TB2       | `conecta4_v1.feature`           | V1 - Gana con 4 colores iguales en linea vertical               |
| TB3       | `conecta4_v1.feature`           | V1 - Gana con 4 colores iguales en diagonal descendente         |
| TB4       | `conecta4_v1.feature`           | V1 - Gana con 4 colores iguales en diagonal ascendente          |
| TB5       | `conecta4_v2.feature`           | V2 - Gana con 4 formas iguales en horizontal (discos)           |
| TB6       | `conecta4_v3.feature`           | V3 - Gana con 4 colores iguales horizontal                      |
| TB7       | `conecta4_v4.feature`           | V4 - Gana con 3 en linea horizontal (N=3)                       |
| TB8       | `conecta4_v5.feature`           | V5 - Gana con 3 en linea horizontal (N=3, sin diagonales)       |
| TB9       | `conecta4_v1.feature`           | V1 - No hay ganador aun si no se alinean 4 del mismo color      |

#### Pair-wise — Diagonales vs. versión (Funcionalidad 2)

| Requisito | Archivo feature                 | Escenario                                                          |
|-----------|---------------------------------|--------------------------------------------------------------------|
| PW1       | `conecta4_v4.feature`           | V4 - Gana con 3 en linea horizontal (N=3)                         |
| PW2       | `conecta4_v5.feature`           | V5 - Gana con 3 en linea vertical (N=3, sin diagonales)           |
| PW3       | `conecta4_v4.feature`           | V4 - Gana con 3 en diagonal descendente (N=3)                     |
| PW4       | `conecta4_v4.feature`           | V4 - Gana con 3 en diagonal ascendente (N=3)                      |
| PW5       | `conecta4_v5.feature`           | V5 - NO gana con 3 en diagonal aunque estén alineadas (sin diag.) |
| PW6       | `conecta4_v5.feature`           | V5 - NO gana con diagonal descendente (N=3, sin diagonales)       |
| PW7       | `conecta4_v5.feature`           | V5 - NO gana con 3 en diagonal aunque estén alineadas (sin diag.) |
| PW8       | `conecta4_v4.feature`           | V4 - No gana con 3 en linea si N es 4                             |
