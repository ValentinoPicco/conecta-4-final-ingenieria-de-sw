package com.conecta4.ui;

import java.util.List;

import com.conecta4.tokens.Token;

public interface UI {
    int intRequest();
    String tokenRequest();
    void show(String print);
    void showList(List<String> tokens);
    void showBoard(Token[][] board);
}
