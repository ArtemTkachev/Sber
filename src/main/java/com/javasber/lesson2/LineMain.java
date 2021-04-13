package com.javasber.lesson2;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LineMain {
    public static void main(String[] args) {
        StringBuilder line = new StringBuilder();

        try (FileReader reader = new FileReader("SberText.txt")) {
            int smbl;
            while ((smbl = reader.read()) != -1) {
                line.append((char) smbl);
            }
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }

        System.out.println(line.toString());

        List<String> wordCount = wordCount(line.toString());
        wordSort(wordCount);
        eachWordCount(wordCount);
        reverseLines(line.toString());
        revIter(line.toString());
        randomLine(line.toString());
    }

    //Задание 1: Подсчитайте количество различных слов в файле.
    private static List<String> wordCount(String line) {
        List<String> words = new ArrayList<>(Arrays.asList(
                line.replaceAll("\r\n", " ").split(" ")));
        System.out.println("\nколичество различных слов в файле: " + words.size());
        return words;
    }

    //Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины (компаратор сначала по длине слова, потом по тексту).
    private static void wordSort(List<String> words) {
        SortedSet<String> wordsSort = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String f, String s) {
                if (f.length() > s.length())
                    return 1;
                else if (f.length() < s.length())
                    return -1;
                else {
                    for (int i = 0; i < Math.min(f.length(), s.length()); i++) {
                        if (f.charAt(i) > s.charAt(i))
                            return 1;
                        else if ((f.charAt(i) < s.charAt(i)))
                            return -1;
                    }
                }
                return 0;
            }
        });

        wordsSort.addAll(words);
        System.out.println();
        wordsSort.forEach(k -> System.out.println(k));
    }


    //Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
    private static void eachWordCount(List<String> words) {
        HashMap<String, Integer> hashMapWord = new HashMap<>();
        words.forEach((String word) -> {
            hashMapWord.computeIfPresent(word, (k, v) -> v + 1);
            hashMapWord.computeIfAbsent(word, k -> 1);
        });
        hashMapWord.forEach((k, v) -> System.out.println("\nслово: " + k + "  кол-во: " + v));
    }

    //Задание 4: Выведите на экран все строки файла в обратном порядке.
    private static void reverseLines(String line) {
        Deque<String> deque = new ArrayDeque<>(Arrays.asList(line.split("\r\n")));
        System.out.println();
        while (!deque.isEmpty()) {
            System.out.println(deque.removeLast());
        }
    }

    //Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.
    private static void revIter(String line) {
        RIList<String> riList = new RIList<>(line.replaceAll("\r\n", " ").split(" "));
        System.out.println();
        for (String word :
                riList) {
            System.out.println(word);
        }
    }

    //Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.
    private static void randomLine(String line) {
        Scanner scanner = new Scanner(System.in);

        List<String> lines = new ArrayList<>(Arrays.asList(line.split("\r\n")));
        System.out.println("\nКоличество строк в файле: " + lines.size());
        int num = 0;
        int attem = 0;
        while (attem < lines.size()) {
            System.out.println("Введите номер строки от 1 до " + lines.size() + ": ");
            num = scanner.nextInt();
            if (num > 0 && num < lines.size() + 1) {
                attem++;
            } else {
                continue;
            }
            System.out.println(lines.get(num - 1));
        }
    }
}



