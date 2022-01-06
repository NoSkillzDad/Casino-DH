package com.mycasino.blackjack;

import java.util.Random;
import java.util.Stack;

public class Deck {
    protected Stack<Card> cards;

    //Default constructor
    public Deck() {
        CardSuit[] suits = new CardSuit[] {
                new CardSuit("diamonds", '\u2666', "red"),
                new CardSuit("spades", '\u2660', "black"),
                new CardSuit("hearts", '\u2665', "red"),
                new CardSuit("clubs", '\u2663', "black"),
        };

        CardValue[] values = new CardValue[] {
                new CardValue("two", 2), new CardValue("three", 3), new CardValue("four",4),
                new CardValue("five", 5), new CardValue("six",6), new CardValue("seven",7),
                new CardValue("eight",8), new CardValue("nine",9), new CardValue("ten",10),
                new CardValue("jack", 10), new CardValue("queen", 10), new CardValue("king", 10)
        };

        cards = new Stack<>();
        for (CardSuit suit : suits) {
            for (CardValue value : values) {
                cards.add(new Card(suit, value));
            }
        }
    }

    public void shuffle() { //is this the fisher-yates shuffling algorithm?
        Random random = new Random();
        for (int i = 0; i < cards.size(); i++) {
            int shuffleIndex = random.nextInt(cards.size());
            Card hold = cards.get(i);
            cards.set(i, cards.get(shuffleIndex));
            cards.set(shuffleIndex, hold);
        }

    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public Card getNextCard() {
        return cards.pop();
    }

}
