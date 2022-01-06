package com.mycasino.blackjack;

public class Dealer {
    public Hand hand;
    private boolean isStaying;

    public Dealer() {
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

//    public void performMove(Deck deck) {
    public void performMove(Deck deck, int playerHandValue) {
//        if (getHandValue() <=17) {
        if (getHandValue() < playerHandValue) {
            this.hand.addCard(deck.getNextCard());
            System.out.println("The dealer got another card!\n");
        } else {
            this.isStaying = true;
            System.out.println("The dealer stays!\n");
        }
    }
}
//    https://boardgames.stackexchange.com/questions/12019/what-are-a-blackjack-dealers-options/12021

//    Blackjack dealers have no options for the in-game decisions of whether to hit or stay; they follow a strict algorithm
//    that will depend on the casino. The dealer waits until the players have exercised all their options, then the dealer
//    reveals their hidden card and hits until they have at least 17 (most common).
//
//    The only variation I'm familiar with is a rule where the dealer will hit a soft 17 (any 17 with an Ace taking the
//    value 11--denoted "H17" for Hit 17, as opposed to "S17" for Stand 17), but this is not the dealer's choice, it will
//    be determined by the casino. According to Wikipedia, this rule will generally be printed on the table if it is being
//    used, and it hurts players. Wikipedia phrases it the other direction: going from H17 to S17. 'Substituting an "H17"
//    rule with an "S17" rule in a game benefits the player, decreasing the house edge by about 0.2%'