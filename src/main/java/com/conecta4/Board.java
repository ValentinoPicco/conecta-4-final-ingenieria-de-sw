package com.conecta4;

import com.conecta4.tokens.EmptyToken;
import com.conecta4.tokens.Token;

public class Board {
    private Token[][] board;
    private int rows, columns;

    public Board(int r, int c){
        rows = r;
        columns = c;
        board = new Token[rows][columns];
        initialize();
    }

    private void initialize(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = new EmptyToken();
            }
        }
    }

    public void insertToken(int r, int c, Token token){
        board[r][c] = token;
    }

    public Token[][] getBoard() {
        return board;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        // Numeración de columnas
        sb.append("   "); // Espacio para alinear con el margen izquierdo de las filas
        for (int i = 0; i < columns; i++) {
            sb.append(String.format("   %2d", (i + 1))); // 5 caracteres por número de columna
        }
        sb.append("\n");

        // Separador horizontal
        String separator = "   +" + "----+".repeat(columns) + "\n";
        
        // Borde superior
        sb.append(separator);

        for (int i = 0; i < rows; i++) {
            // Número de fila y borde izquierdo
            sb.append(String.format("%2d |", (i + 1)));
            
            for (int j = 0; j < columns; j++) {
                String rep = board[i][j].getRepresentation();
                // Normalizamos cadenas vacías para que midan exactamente 2 espacios visuales
                if (rep == null || rep.trim().isEmpty()) {
                    rep = "";
                }
                // Imprimimos la ficha centrada/alineada en un espacio de 2 caracteres, más sus bordes
                sb.append(String.format(" %2s |", rep));
            }
            sb.append("\n");
            
            // Separador inferior de la fila
            sb.append(separator);
        }
        
        return sb.toString();
    }
}
