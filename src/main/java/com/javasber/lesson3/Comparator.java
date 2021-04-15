package com.javasber.lesson3;

public class Comparator<T> implements Comparable<T>{
    @Override
    public int compareTo(Object o) {
        return o.hashCode() >= o.hashCode() ? 1 : -1;
    }
}
