package com.mycasino.slots.machines;

import java.util.ArrayList;

public abstract class SlotMachine {
    private final String name;
    protected ReelDeck reelDeck;

    public SlotMachine(String name, int numOfReels) {
        this.name = name;

        var reels = new ArrayList<Reel>();
        for (int i = 0; i < numOfReels; i++) {
            reels.add(new Reel());
        }
        this.reelDeck = new ReelDeck(reels);
    }

    public void renderIntro() {
        System.out.println("+-----$$$==| LET'S PLAY |==$$$-----+");
        System.out.println(name);
        System.out.println("+-----$$$__________________$$$-----+\n\n");

        System.out.println("WINNING CONDITIONS\n");
        System.out.println(winningConditions());
    }

    public int roll() {
        reelDeck.roll();
        return calculatePayout();
    }

    public String render() {
        return reelDeck.render();
    }

    public abstract int getRollPrice();

    protected abstract int calculatePayout();

    protected abstract String winningConditions();



}
