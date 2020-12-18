package ru.geekbrains;


import java.util.*;

//  Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
//  Найти и вывести список уникальных слов,
//  из которых состоит массив (дубликаты не считаем).
//  Посчитать, сколько раз встречается каждое слово.
public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "замок", "шпора", "лимузин", "указка",
                " ослик", "лимузин", "кит", "замок",
                "лимузин", "маркиз", "лаваш", "креветка",
                "лимузин", "кит", "лавина", "тесто",
                "комикс", "кит", "тормоз", "лимузин"
        );

        Set<String> unique = new HashSet<String>(words);

        System.out.println("Первоначальный массив");
        System.out.println(words.toString());
        System.out.println("Уникальные слова");
        System.out.println(unique.toString());
        System.out.println("Частота встречаемости слов");
        for (String key : unique) {
            System.out.println(key + ": " + Collections.frequency(words, key));
        }
    }
}
