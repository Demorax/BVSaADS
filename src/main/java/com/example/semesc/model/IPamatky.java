package com.example.semesc.model;

import com.example.semesc.enums.eTypKey;
import com.example.semesc.enums.eTypProhl;

import java.util.Iterator;

public interface IPamatky {
    int importDatZTEXT();
    void vlozZamek(Zamek zamek);
    Zamek najdiZamek(String klic);
    Zamek odeberZamek(String klic);
    void zrus();
    void prebuduj();
    void nastavKlic(eTypKey typ);

    Zamek najdiNejbliz(String klic);
    Iterator vytvorIterator(eTypProhl typ);
}
