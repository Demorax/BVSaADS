package com.example.semesc.model;


public class Zamek implements Comparable<Zamek> {
    int id;
    String nazev;
    Gps gps;

    public Zamek(int id, String nazev, Gps gps) {
        this.id = id;
        this.nazev = nazev;
        this.gps = gps;
    }


    public String getNazev() {
        return nazev;
    }


    public Gps getGps() {
        return gps;
    }

    @Override
    public String toString() {
        return "Zamek{" +
                "id=" + id +
                ", nazev='" + nazev + '\'' +
                ", gps=" + gps +
                '}';
    }


    @Override
    public int compareTo(Zamek o) {
        int vzdalenost = (int) Math.sqrt(Math.pow((o.getGps().getN()-this.gps.getN()), 2)
                +
                Math.pow((o.getGps().getE()-this.gps.getE()), 2));
        return vzdalenost;
    }
}
