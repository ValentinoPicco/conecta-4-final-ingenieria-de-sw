package com.conecta4.ui;

import java.util.List;

public interface UI {
    int intRequest();
    String tokenRequest();
    void show(String print);
    void showList(List<String> tokens);
}
