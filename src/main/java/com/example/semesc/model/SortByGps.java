package com.example.semesc.model;

import java.util.Comparator;

public class SortByGps implements Comparator<Zamek> {

    @Override
    public int compare(Zamek o1, Zamek o2) {

        return (int) (Math.abs(o1.getGps().getN() - o1.getGps().getE()) - Math.abs(o2.getGps().getN() - o2.getGps().getE()));
    }

}
