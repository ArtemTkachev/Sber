package com.javasber.lesson2;

import java.util.*;

public class JavaCollections {
    public static void main(String[] args) {
        Person[] persons = new Person[]{
                new Person(3L, "Leo", 78),
                new Person(1L, "Ace", 18),
                new Person(2L, "Deer", 25),
                new Person(5L, "Kurt", 10),
                new Person(4L, "Fin", 44)};

        List<Person> list = linkedList(persons);
        System.out.println(list.toString());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        Set<Person> treeSet = treeSet(persons);
        System.out.println(treeSet.toString());
        treeSet.forEach(p -> System.out.println(p));

        Map<Long, Person> hashMap = hashMap(persons);
        hashMap.forEach((k, v) -> System.out.println("key: " + k + "  value: " + v));


    }

    private static List arrayList(Person[] persons) {
        List<Person> arrayList = new ArrayList<Person>(Arrays.asList(persons));
        return arrayList;
    }

    private static List linkedList(Person[] persons) {
        List<Person> linkedList = new LinkedList<Person>(Arrays.asList(persons));
        return linkedList;
    }

    private static Set treeSet(Person[] persons) {
        Set<Person> treeSet = new TreeSet<Person>(Arrays.asList(persons));
        return treeSet;
    }

    private static Map<Long, Person> hashMap(Person[] persons) {
        Map<Long, Person> hashMap = new HashMap<>();
        for (Person person :
                persons) {
            hashMap.put(person.getId(), person);
        }
        return hashMap;
    }

}
