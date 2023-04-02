package com.example.semesc.strom;

import com.example.semesc.enums.eTypProhl;

import java.util.Iterator;

public interface IABSTRTABLE<K extends Comparable<K>, V>  {
    void zrus();

    boolean jePrazdny();

    V najdi(K key);

    void vloz(K key, V value);

    V odeber(K key);

    Iterator vytvorIterator(eTypProhl typ);


}
