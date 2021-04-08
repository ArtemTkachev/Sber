package com.javasber.lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
Назовем открывающим тегом строку <x>,
где x — любая строчная буква латинского алфивита.
Каждому открывающему тегу соответствует закрывающий тег вида </x>,
где x — та же самая буква.

Теги могут вкладываться друг в друга:
в этому случае одна пара из открывающего и закрывающего тега находится внутри другой пары.

Определим понятие XML-текста:
пустая строка — это XML-текст
если s — это XML-текст, то s' = <a> + s + </a> — тоже XML-текст, где a — любая строчная буква латинского алфавита
если s1, s2 — это XML-тексты, то s1 + s2 — тоже XML-текст

Вам дан XML-текст (гарантируется, что он корректен), ваша задача — вывести его в формате:
каждый тег (как открывающий, так и закрывающий) находится на отдельной строке
перед тегом выводится 2*h пробелов, где h — уровень вложенности тега.

Входные данные
Входные данные состоят из единственной строки — XML-текста, его длина не превосходит 1000 символов. Гарантируется корректность этого текста.

Выходные данные
Выведите данный XML-текст в соответствии с описанными выше правилами.
*/
public class LinesMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String xmlInput = scanner.nextLine();
        List<String> list = Arrays.asList(xmlInput.split("<"));
        String[] spaсes = new String[list.size()];
        String[] symbols = new String[list.size()];
        int ind = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).contains("/")) {
                for (int j = 0; j < symbols.length; j++) {
                    if (symbols[j].charAt(0) == list.get(i).charAt(1)) {
                        sb.append(spaсes[j]);
                        sb.append("</" + symbols[j]);
                        break;
                    }
                }
            } else {
                symbols[ind] = list.get(i);
                spaсes[ind] = "";
                if (ind > 0) {
                    if (list.get(i - 1).contains("/")) {
                        spaсes[ind] = spaсes[ind - 1];
                    } else {
                        spaсes[ind] = spaсes[ind - 1] + "  ";
                    }
                }
                sb.append(spaсes[ind]);
                sb.append("<" + symbols[ind]);
                ind++;
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
