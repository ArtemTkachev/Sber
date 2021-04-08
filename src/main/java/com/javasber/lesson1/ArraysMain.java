package com.javasber.lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
Заданы два массива целых положительных чисел: a и b.
Ваша задача сформировать такой массив c, содержащий все элементы массива a,
которые встречаются в b. В массиве c элементы должны идти в том же порядке,
что и a, просто пропускайте те элементы, что не присутствуют в b.

Входные данные
В первой строке записано целое положительное число n (1 ≤ n ≤ 10000),
n — количество элементов массива a.
Вторая строка содержит n целых чисел: a1, a2,..., an (1 ≤ ai ≤ 10000). Числа записаны через пробел.
Третья и четвертая строки содержат описание массива b в формате, полностью совпадающем с форматом описания массива a.

Выходные данные
Выведите искомый массив c в формате, повторяющем формат массивов во входных данных.
Если искомый массив пустой, то в первую строку выведите 0, а вторую оставьте пустой.
 */
public class ArraysMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите n первого массива:");
        int[] arrF = new int[scanner.nextInt()];
        System.out.println("Введите элементы первого массива:");
        for (int i = 0; i < arrF.length; i++) {
            arrF[i] = scanner.nextInt();
        }

        System.out.println("Введите n второго массива:");
        int[] arrS = new int[scanner.nextInt()];
        System.out.println("Введите элементы второго массива:");
        for (int i = 0; i < arrS.length; i++) {
            arrS[i] = scanner.nextInt();
        }

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arrF.length; i++) {
            for (int y = 0; y < arrS.length; y++) {
                if (arrF[i] == arrS[y]) {
                    list.add(arrF[i]);
                    break;
                }
            }
        }

        System.out.println("Ответ: n массива - " + list.size() +
                "\nЭлементы массива: " + Arrays.toString(list.toArray()));
    }
}
