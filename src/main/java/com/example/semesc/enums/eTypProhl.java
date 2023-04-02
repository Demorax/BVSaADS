package com.example.semesc.enums;

public enum eTypProhl {
    SIRKY("do šířky"),
    HLOUBKY("do hloubky");

    public final String typProhl;

    eTypProhl(String typProhl) {
        this.typProhl = typProhl;
    }

    public String getTypProhl() {
        return typProhl;
    }
}
