package com.javasber.lesson3;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T>{

    private final HashMap<T, Integer> hashMap = new HashMap<>();

    public CountMapImpl() {
        super();
    }

    @Override
    public void add(T t) {
        hashMap.computeIfPresent(t, (k, v) -> v + 1);
        hashMap.computeIfAbsent(t, v -> 1);
    }

    @Override
    public int getCount(T t) {
        return hashMap.getOrDefault(t, 0);
    }

    @Override
    public int remove(T t) {
        Integer value = hashMap.remove(t);
        return value == null ? 0 : value;
    }

    @Override
    public int size() {
        return hashMap.size();
    }

    @Override
    public void addAll(CountMap<T> source) {
        source.toMap().forEach((k, v) -> {
            this.add(k);
        });
    }

    @Override
    public Map<T, Integer> toMap() {
        return (Map<T, Integer>) hashMap;
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        destination.putAll(hashMap);
    }
}
