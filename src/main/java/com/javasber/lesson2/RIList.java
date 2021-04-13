package com.javasber.lesson2;

import java.util.Iterator;

public class RIList<T> implements Iterable<T> {

    private T[] arrayList;
    private int size;

    public RIList(T[] arrayList) {
        this.arrayList = arrayList;
        this.size = arrayList.length;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int index = size - 1;

            @Override
            public boolean hasNext() {
                return index >= 0 && arrayList[index] != null;
            }

            @Override
            public T next() {
                return arrayList[index--];
            }
        };
    }
}