package com.mycasino.blackjack;

import java.util.Scanner;

public abstract class BlackJackGame {
    protected Scanner scannerIn;
    protected boolean isGameRunning;

    protected Deck deck;
    protected Player player;
    protected Dealer dealer;

    public BlackJackGame(Scanner scannerIn, Deck deck) {
        this.scannerIn = scannerIn;
        this.deck = deck;
    }

    public void playGame() {
        isGameRunning = true;

        player = new Player();
        dealer = new Dealer();

        deck.shuffle();
        dealer.addCards2Hand(deck.getNextCard());
        player.addCards2Hand(deck.getNextCard(), deck.getNextCard());

        while (isGameRunning) {
            gameLoop();
        }
    }
    abstract void gameLoop();
}