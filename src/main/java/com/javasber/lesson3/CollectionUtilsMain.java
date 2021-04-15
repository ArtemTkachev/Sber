package com.javasber.lesson3;

import com.javasber.lesson3.items.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionUtilsMain {
    public static void main(String[] args) {
        Animal animal = new Animal("A");
        Elephant elephant = new Elephant("E");
        Rhino rhino = new Rhino("R");
        WhiteRhino whiteRhino = new WhiteRhino("WR");
        Dandelion dandelion = new Dandelion("D");
        List<Animal> animals1 = new ArrayList<>(Arrays.asList(animal, elephant));
        List<Animal> animals2 = new ArrayList<>(Arrays.asList(rhino, whiteRhino));

        CollectionUtils.addAll(animals1, animals2);
        animals2.forEach(System.out::println);

        List<Animal> animals3 = CollectionUtils.newArrayList();

        int index = CollectionUtils.indexOf(animals2, whiteRhino);
        System.out.println("\nindex: " + index);

        System.out.println();
        List<Animal> animals4 = CollectionUtils.limit(animals2, 3);
        animals4.forEach(System.out::println);


        System.out.println("\n" + CollectionUtils.containsAll(animals2, animals1));

        System.out.println("\n" + CollectionUtils.containsAny(animals2, animals1));

        CollectionUtils.removeAll(animals2, animals1);
        System.out.println();
        animals2.forEach(System.out::println);

        CollectionUtils.add(animals2, whiteRhino);
        System.out.println();
        animals2.forEach(System.out::println);
    }
}
