package com.mycasino.slots.machines.highroller;

import com.mycasino.slots.Symbol;
import com.mycasino.slots.machines.SlotMachine;

public class HighRoller extends SlotMachine {
    public HighRoller() {
        super("High Roller Slot Machine", 3);
    }

    @Override
    public int getRollPrice() {
        return 10;
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
        return "3x star    | 50 tokens\n" + "3x yinyang | 100 tokens\n" + "3x spade   | 150 tokens\n"
                + "3x heart   | 200 tokens\n" + "3x club    | 250 tokens\n";
    }
}
