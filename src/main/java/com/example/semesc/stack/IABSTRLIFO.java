package com.example.semesc.stack;

import java.util.Iterator;

public interface IABSTRLIFO<T>{
    void zrus();

    boolean jePrazdny();

    void vloz(T data);

    T odeber();

    Iterator vytvorIterator();

}
