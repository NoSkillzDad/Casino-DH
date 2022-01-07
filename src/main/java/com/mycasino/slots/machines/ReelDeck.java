package com.mycasino.slots.machines;

import com.mycasino.slots.Symbol;

import java.util.List;

public class ReelDeck {
    private List<Reel> reels;

    public ReelDeck(List<Reel> reels) {
        this.reels = reels;
    }

    public void roll() {
        for (Reel reel : reels) {
            reel.roll();
        }
    }

    public String render() {
        var renderedReels = "";

        for (Reel reel : reels) {
            renderedReels = renderedReels + " " + reel.render();
        }
        return renderedReels;
    }

    public boolean allReelsMatchSymbol(Symbol symbol) {
        for (Reel reel : reels) {
            if (reel.getSymbol() != symbol) {
                return false;
            }
        }
        return true;
    }
}
