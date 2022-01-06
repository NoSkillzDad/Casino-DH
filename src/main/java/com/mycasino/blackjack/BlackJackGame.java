package com.mycasino.blackjack;

import java.util.Scanner;

public class BlackJackGame {
    private Scanner scannerIn;
    private boolean isGameRunning;

    private Deck deck;
    private Player player;
    private Dealer dealer;

    public BlackJackGame(Scanner scannerIn) {
        this.scannerIn = scannerIn;
        this.deck = new Deck();
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

    public void gameLoop() {
        renderTable();

        if (dealer.isBust() || (dealer.isStaying() && player.getHandValue() > dealer.getHandValue())) {
            System.out.println("You won!");
            isGameRunning = false;
            return;
        }

        if (player.isBust() || (player.isStaying() && dealer.getHandValue() >= player.getHandValue())) {
            System.out.println("The house wins!");
            isGameRunning = false;
            return;
        }

        if (!player.isStaying()) {
            String move = getUserNextMove();
            player.performMove(deck, move);
        }

         if (!dealer.isStaying() && !player.isBust() && player.isStaying()) {
             dealer.performMove(deck, player.getHandValue());
         }
    }

    public String getUserNextMove() {
        while (true) {
            System.out.println("What's your next move? (hit / stay)");
            String input = scannerIn.nextLine();
            if (input.equals("hit") || input.equals("stay")) {
                return input;
            }
        }
    }

    private void renderTable() {
        System.out.println("\nDealers' hand: ");
        System.out.println(dealer.renderHand());
        System.out.println("\nYour hand: ");
        System.out.println(player.renderHand());
        System.out.println("-------------------");
    }


    //playgame()
    //  deal cards player/dealer
    //  show cards to player
    //  wait for player input
    //      pass -> store totalvalue -> go over to dealer
    //      get a new card -> get totalvalue
    //          if over 21 then busted else go back to player input
}