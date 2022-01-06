package com.aperalta.casino;

/****** suits to int mapping
Clubs -> 0
Diamonds -> 1
Hearts -> 2
Spades -> 3

Ace -> 1
Jack -> 11
Queen -> 12
King -> 13
*/

public class CardLJ {
    public static final String[] RANKS = {null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    public static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};

    private final int rank;
    private final int suit;

    //Constructors
    public CardLJ(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    //Getters
    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    public boolean areCardEquals(CardLJ that) {
        return this.rank == that.rank && this.suit == that.suit;
    }

    //Compares 2 cards, rank comparison is based on comment at the beginning of this class.
    public int compareTo(CardLJ that) {
        if (this.suit < that.suit) {
            return -1;
        }
        if (this.suit > that.suit) {
            return 1;
        }
        if (this.rank < that.rank) {
            return -1;
        }
        if (this.rank > that.rank) {
            return 1;
        }
        return 0;
    }

    public int positionInDeck() {
        return this.suit * 13 + this.rank - 1;
    }

    @Override
    public String toString() {
        String s = RANKS[this.rank] + " of " + SUITS[this.suit];
        return s;
    }

}










/************** Using ENUM
public class Card implements Comparable<Card>{

    public enum Rank {
        DEUCE(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9),
        TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);

        private Integer rankValue;

        public final Integer getRankValue() {
            return this.rankValue;
        }

        Rank(final int rv) {
            this.rankValue = rv;
        }

        public Integer CardValue() {
            return this.rankValue;
        }
    }

    public enum Suit {
        CLUBS(2), DIAMONDS(3), HEARTS(4), SPADES(1);

        private Integer suitValue;

        public final Integer getSuitValue() {
            return this.suitValue;
        }

        Suit(final int sv) {
            this.suitValue = sv;
        }

        public Integer SuitValue() {
            return this.suitValue;

        }

    }

    private final Rank rank;
    private final Suit suit;

    protected Card(final Rank rank, final Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank rank() {
        return rank;
    }

    public Suit suit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit + "(" + cardValue() + ")";
    }

    public Integer cardValue() {
        return rank.getRankValue() * suit.getSuitValue();
    }

    @Override
    public int compareTo(Card o) {
        return -this.cardValue().compareTo(o.cardValue());
    }

}
*/
