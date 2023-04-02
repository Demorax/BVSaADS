package com.example.semesc.halda;

import com.example.semesc.queu.ABSTRFIFO;
import com.example.semesc.stack.ABSTRLIFOI;
import com.example.semesc.enums.eTypProhl;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class AbstrHeapImplNew<V extends Comparable<V>> implements AbstrHeap<V> {

    private Comparable[] array;
    private Object hledany;
    private int size = 0;

    public AbstrHeapImplNew() {
    }

    public int getSize() {
        return size;
    }

    public void setHledany(Object hledany) {
        this.hledany = hledany;
    }

    public void setSize(int size) {
        this.array =  new Comparable[size];
        this.size = size;
    }

    @Override
    public void vybuduj(Comparable[] arr) {
        this.array = arr;
        for (int i = arr.length / 2; i >= 1 ; i--) {
            prebuduj(arr, i);
        }

        for (int i = this.array.length - 2; i >= 0; i--) {
            V tmp = (V) arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            prebuduj(arr,0);
        }
    }

    @Override
    public void prebuduj(Comparable[] arr, int i) {
        int large = i;
        int left = 2 * i;
        int right = 2 * i + 1;

        if (left <= arr.length-1 && arr[left].compareTo(this.hledany) < arr[large].compareTo(this.hledany)) {
            large = left;
        }

        if (right <= arr.length-1 && arr[right].compareTo(this.hledany) < arr[large].compareTo(this.hledany)) {
            large = right;
        }
        if (large != i) {
            swap(large, i);
            prebuduj(arr, large);
        }

        this.array = arr;

    }
    private void swap(int first, int second)  {
        Comparable tmp;
        tmp = this.array[first];
        this.array[first] =  this.array[second];
        this.array[second] = tmp;
    }

    @Override
    public void zrus() {
        this.array = null;
        this.size = 0;
        this.hledany = null;
    }

    @Override
    public boolean jePrazdny() {
        return this.size == 0;
    }

    @Override
    public void vloz(V item) {
        if (jePrazdny()) {
            setSize(1);
            this.array[0] = item;
        } else {
            this.array = Arrays.copyOf(array, array.length + 1);
            this.array[size++] = item;
            int current = size - 1;
            while (this.array[current].compareTo(this.hledany) < this.array[parent(current)].compareTo(this.hledany)){
                swap(current, parent(current));
                current = parent(current);
            }
        }
        prebuduj(this.array, 0);

    }

    @Override
    public V odeberMax() {
        if (jePrazdny()) {
            return null;
        } else if (this.array.length == 1) {
            Comparable min = this.array[0];
            this.array = null;
            return (V) min;
        }

        Comparable min = this.array[0];
        Comparable lastItem = this.array[this.array.length - 1];
        this.array = Arrays.copyOf(array, array.length - 1);
        this.array[0] = lastItem;
        prebuduj(this.array, 0);
        this.size = this.array.length;
        return (V) min;
    }

    @Override
    public V zprusupniMax() {
        return this.array.length != 0 ? (V) this.array[0] : null;
    }

    @Override
    public Iterator vytvorIterator(eTypProhl typ) {
        ABSTRLIFOI<Comparable> stack = new ABSTRLIFOI<>();
        ABSTRFIFO<Comparable> queue = new ABSTRFIFO<>();
        switch (typ){
            case HLOUBKY -> {

                for (Comparable j : this.array)
                    stack.vloz(j);
                return new Iterator() {
                    @Override
                    public boolean hasNext() {
                        if (stack.jePrazdny()) {
                            return false;
                        }
                        return true;
                    }

                    @Override
                    public Object next() {
                        if (!hasNext()) {
                            throw new NoSuchElementException();
                        }

                        Comparable current = stack.odeber();
                        return current;
                    }

                };

            }
            case SIRKY -> {
                for (Comparable j : this.array)
                    queue.vloz(j);
                return new Iterator() {
                    @Override
                    public boolean hasNext() {
                        if (queue.jePrazdny()) {
                            return false;
                        }
                        return true;
                    }

                    @Override
                    public Object next() {
                        if (!hasNext()) {
                            throw new NoSuchElementException();
                        }

                        Comparable current = queue.odeber();
                        return current;
                    }

                };
            }
        }

        return null;
    }

    private int parent(int pos)  {
        return pos / 2;
    }
}
