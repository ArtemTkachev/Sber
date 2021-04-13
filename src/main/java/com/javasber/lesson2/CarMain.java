package com.javasber.lesson2;

import java.util.*;

public class CarMain {
    public static void main(String[] args) {
        List<Car> listCars =
                new ArrayList<Car>(Arrays.asList(new Car("Lada", "sedan"),
                        new Car("Lada", "hatchback"), new Car("Mersedes", "sedan"),
                        new Car("BMW", "crossover"), new Car("Ford", "hatchback"),
                        new Car("Peugeot", "crossover"), new Car("Toyota", "sedan")));

        HashMap<String, List<Car>> hashMapCars = new HashMap<>();
        listCars.forEach((Car car) -> {
            if (hashMapCars.containsKey(car.getType())) {
                hashMapCars.get(car.getType()).add(car);
            } else {
                List<Car> carType = new ArrayList<Car>();
                carType.add(car);
                hashMapCars.put(car.getType(), carType);
            }
        });

        hashMapCars.forEach((k, v) -> System.out.println(k + ": " + v.toString() + "\n"));
    }
}


