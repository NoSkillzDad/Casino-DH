package com.mycasino.slots.machines.fivereeler;

import com.mycasino.slots.Symbol;
import com.mycasino.slots.machines.SlotMachine;

public class FiveReeler extends SlotMachine {

    public FiveReeler() {
        super("Five Slot Machine", 5);
    }

    @Override
    public int getRollPrice() {
        return 5;
    }

    @Override
    protected int calculatePayout() {
        if (this.reelDeck.allReelsMatchSymbol(Symbol.STAR)) {
            return 50;
        }

        if (this.reelDeck.allReelsMatchSymbol(Symbol.YINYANG)) {
            return 100;
        }

        if (this.reelDeck.allReelsMatchSymbol(Symbol.SPADE)) {
            return 150;
        }

        if (this.reelDeck.allReelsMatchSymbol(Symbol.CLUB)) {
            return 200;
        }

        if (this.reelDeck.allReelsMatchSymbol(Symbol.HEART)) {
            return 250;
        }

        return 0;
    }

    @Override
    protected String winningConditions() {
        return "5x star    | 50 tokens\n" + "5x yinyang | 100 tokens\n" + "5x spade   | 150 tokens\n"
                + "5x heart   | 200 tokens\n" + "5x club    | 250 tokens\n";
    }
}
