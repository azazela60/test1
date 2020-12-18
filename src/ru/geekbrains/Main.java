package ru.geekbrains;

//  Написать простой класс Телефонный Справочник,
//  который хранит в себе список фамилий и телефонных номеров.
//  В этот телефонный справочник с помощью метода add()
//  можно добавлять записи, а с помощью метода get()
//  искать номер телефона по фамилии.
//  Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
//  тогда при запросе такой фамилии должны выводиться все телефоны.

public class Main {
    public static void main(String[] args) {
        System.out.println("Создаем справочник");
        Phonebook phonebook = new Phonebook();
        System.out.println("-----------------");

        System.out.println("Наполняем справочник");
        phonebook.add("Абакумов", "213344");
        phonebook.add("Абакумов", "22334411");
        phonebook.add("Абакшин", "22334499");
        phonebook.add("Бабаев", "22314488");
        phonebook.add("Бакулев", "11334455");
        phonebook.add("Галанов", "12345678");
        phonebook.add("Жабин", "87654321");
        phonebook.add("Кабанов", "47654320");
        phonebook.add("Абакумов", "22334422");
        System.out.println("-----------------");

        System.out.println("Получаем номера");
        System.out.println("Абакумов");
        System.out.println(phonebook.get("Абакумов"));
        System.out.println("Абакшин");
        System.out.println(phonebook.get("Абакшин"));
        System.out.println("Кабанов");
        System.out.println(phonebook.get("Кабанов"));
        System.out.println("-----------------");

        System.out.println("Случай отсутствия записи");
        System.out.println("Кузнецов");
        System.out.println(phonebook.get("Кузнецов"));
        System.out.println("-----------------");

        System.out.println("Пробуем записать существующий номер");
        phonebook.add("Абакумов", "223344");
        System.out.println("Абакумов");
        System.out.println(phonebook.get("Абакумов"));
    }
}
