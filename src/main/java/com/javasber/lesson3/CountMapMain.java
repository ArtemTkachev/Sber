package com.javasber.lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountMapMain {
    public static void main(String[] args) {
        CountMap<Integer> map = new CountMapImpl<>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);
        map.add(7);

        System.out.println(map.getCount(5));  // 2
        System.out.println(map.getCount(6));  // 1
        System.out.println(map.getCount(10)); // 3
        System.out.println(map.getCount(7)); //1

        System.out.println();
        System.out.println(map.remove(10)); //3
        System.out.println(map.size()); //3

        System.out.println();
        CountMap<Integer> insertMap = new CountMapImpl<>();
        insertMap.add(4);
        insertMap.add(4);
        insertMap.add(5);
        map.addAll(insertMap);
        System.out.println(map.getCount(4)); //1
        System.out.println(map.getCount(5)); //3
        System.out.println(map.size()); //4

        Map<Integer, Integer> dest = map.toMap();
        System.out.println();
        dest.forEach((k, v) -> System.out.println(k + ": " + v));

        Map<Integer, Integer> destination = new HashMap<>();
        map.toMap(destination);
        System.out.println();
        destination.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
