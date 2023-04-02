package com.example.semesc.halda;

import java.util.Iterator;

import com.example.semesc.enums.eTypProhl;

public interface AbstrHeap<V extends Comparable<V>>  {
    void vybuduj(Comparable[] arr);

    void prebuduj(Comparable[] arr, int i);

    void zrus();

    boolean jePrazdny();

    void vloz(V item);

    V odeberMax();

    V zprusupniMax();

    Iterator vytvorIterator(eTypProhl typ);
}
