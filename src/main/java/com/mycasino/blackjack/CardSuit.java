package com.mycasino.blackjack;

public class CardSuit {
    private String name;
    char symbol;
    String color;

    public CardSuit(String name, char symbol, String color) {
        this.name = name;
        this.color =  color;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getColor() {
        return color;
    }
}
