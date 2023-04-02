package com.example.semesc.enums;

public enum eTypKey {
    NAZEV("název památky"),
    GPS("gps památky");

    public final String typKey;

    eTypKey(String typKey) {
        this.typKey = typKey;
    }

    public String getTypKey() {
        return typKey;
    }
}
