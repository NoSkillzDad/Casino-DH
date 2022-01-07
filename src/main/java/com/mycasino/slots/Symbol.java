package com.mycasino.slots;

public enum Symbol {
    STAR('\u22C6'), YINYANG('\u262F'), SPADE('\u2664'), HEART('\u2661'), CLUB('\u2667');

    public final char icon;

    Symbol(char icon) {
        this.icon = icon;
    }
}
