package com.javasber.lesson1;

import com.javasber.lesson1.Person;

public class AppPersonMarryDivorce {
    public static void main(String[] args) {
        Person artem = new Person(true, "artem");
        Person marina = new Person(false, "marina");
        Person vlad = new Person(true, "vlad");
        Person anna = new Person(false, "anna");
        vlad.marry(anna);
        artem.marry(marina);
        artem.marry(anna);
        System.out.println(artem.getSpouse().getName());
    }
}
