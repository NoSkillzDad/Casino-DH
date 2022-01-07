package com.mycasino.slots.machines.penny;

import com.mycasino.slots.Symbol;
import com.mycasino.slots.machines.SlotMachine;

public class Penny extends SlotMachine {

    public Penny() {
        super("Penny Slot Machine", 3);
    }

    @Override
    public int getRollPrice() {
        return 1;
    }

    @Override
    protected int calculatePayout() {
        if (this.reelDeck.allReelsMatchSymbol(Symbol.STAR)) {
            return 5;
        }

        if (this.reelDeck.allReelsMatchSymbol(Symbol.YINYANG)) {
            return 10;
        }

        if (this.reelDeck.allReelsMatchSymbol(Symbol.SPADE)) {
            return 15;
        }

        if (this.reelDeck.allReelsMatchSymbol(Symbol.CLUB)) {
            return 20;
        }

        if (this.reelDeck.allReelsMatchSymbol(Symbol.HEART)) {
            return 25;
        }

        return 0;
    }

    @Override
    protected String winningConditions() {
        return "3x star    | 5 tokens\n" + "3x yinyang | 10 tokens\n" + "3x spade   | 15 tokens\n"
                + "3x heart   | 20 tokens\n" + "3x club    | 25 tokens\n";
    }
}
