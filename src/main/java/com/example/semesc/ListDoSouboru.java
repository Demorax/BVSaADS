package com.example.semesc;

import com.example.semesc.model.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class ListDoSouboru {

    private Iterator<Zamek> iterator;

    public ListDoSouboru(Iterator<Zamek> iterator) {
        this.iterator = iterator;
    }

    public boolean listDoBina() throws IOException {
        String fileName = "pepa.csv";
        try {
            FileWriter fw = new FileWriter(fileName);
            if (!this.iterator.hasNext()) {
                return false;
            } else {
                Zamek temp = this.iterator.next();
                while (this.iterator.hasNext()){
                        fw.write(temp.getGps().getN() + ";" + temp.getGps().getE() + ";" + temp.getNazev() + "\n");
                    temp = this.iterator.next();
                }
            }
            fw.close();
            return true;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
