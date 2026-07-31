package com.conecta4.ui;

import java.util.List;
import java.util.Scanner;

import com.conecta4.tokens.Token;

public class ConsoleUI implements UI{
    private Scanner scanner;

    public ConsoleUI(Scanner sc){
        scanner = sc;
    }

    // mejorables
    @Override
    public int intRequest() {
        return scanner.nextInt();
    }

    @Override
    public String tokenRequest() {
        return scanner.next();
    }

    @Override
    public void show(String print) {
        System.out.println(print);
    }

    @Override
    public void showList(List<String> tokens) {
        int i = 1;
        for (String token : tokens) {
            System.out.println(i + ". " + token);
        }
        i++;
    }

    @Override
    public void showBoard(Token[][] board) {
        int rows = board.length;
        int columns = board[0].length;
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
        
        System.out.println(sb.toString());
    }
}
