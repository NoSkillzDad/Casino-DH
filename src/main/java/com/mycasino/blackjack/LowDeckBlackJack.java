package com.mycasino.blackjack;

import java.util.Scanner;

public class LowDeckBlackJack extends BlackJackGame {
    public LowDeckBlackJack(Scanner inputScanner) {
        super(inputScanner, new LowDeck());
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

}
