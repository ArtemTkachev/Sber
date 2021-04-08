package com.javasber.lesson1;

import java.util.Scanner;

public class CyclesMain {

    /*
    Альтернированной суммой заданной последовательности n чисел a1, a2,..., an
    называется число s=a1-a2+a3-a4+....
    В альтернированной сумме знаки слагаемых чередуются, альтернация начинается со знака "+".
    По заданной последовательности целых чисел выведите ее альтернированную сумму.

    Входные данные
    В первой строке задано целое число n (1 ≤ n ≤ 10000).
    Вторая строка содержит n целых чисел, каждое от 1 до 10000 включительно.

    Выходные данные
    Выведите искомую альтернированную сумму.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        System.out.println("Введите n:");
        int count = scanner.nextInt();
        System.out.println("Введите n чисел:");
        for (int i = 0; i < count; i++) {
            if (i % 2 == 0) {
                sum += scanner.nextInt();
            } else {
                sum -= scanner.nextInt();
            }
        }

        System.out.println("Ответ: " + sum);
    }
}
