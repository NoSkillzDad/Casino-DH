package com.mycasino.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public Hand hand;
    private boolean isStaying;

    public Player() {
        this.hand = new Hand();
    }

    public int getHandValue() {
        return hand.getTotalValue();
    }

    public void addCards2Hand(Card... cards) {
        for (Card card : cards) {
            hand.addCard(card);
        }
    }

    public boolean isStaying() {
        return isStaying;
    }

    public boolean isBust() {
//        return hand.getTotalValue() > 21;
        return getHandValue() > 21;
    }

    public String renderHand() {
        return hand.render();
    }

    public void performMove(Deck deck, String move) {
        if (move.equals("hit")) {
            this.hand.addCard(deck.getNextCard());
            System.out.println("You got another card!\n");
        } else if (move.equals("stay")) {
            this.isStaying = true;
            System.out.println("You stay!\n");
        }
    }
}
