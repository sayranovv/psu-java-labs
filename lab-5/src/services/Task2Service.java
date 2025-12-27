package services;

import entities.*;
import java.util.*;

public class Task2Service {

    public void runTask2() {

        System.out.println("─── СОЗДАНИЕ КОТА ───\n");
        Cat myCat = new Cat("Пушок");
        System.out.println("Создан кот: " + myCat);
        System.out.println("Начальный счетчик мяуканий: " + myCat.getMeowCount());

        System.out.println("\n─── ПРЯМОЕ МЯУКАНЬЕ КОТА ───\n");
        myCat.meow();
        myCat.meow();
        myCat.meow();
        System.out.println("Счетчик мяуканий после 3 мяуканий: " + myCat.getMeowCount());

        myCat.resetMeowCount();
        System.out.println("\nСчетчик сброшен: " + myCat.getMeowCount());

        System.out.println("\n\n─── СТРУКТУРНЫЙ ПАТТЕРН: РАБОТА ЧЕРЕЗ ИНТЕРФЕЙС ───\n");
        System.out.println("Передаем кота (через интерфейс Meowable) в метод makeThemMeow()");
        System.out.println("Метод вызывает meow() у всех переданных объектов:\n");

        Meowable[] meowables = { myCat };

        makeThemMeow(meowables);

        System.out.println("\n--- РЕЗУЛЬТАТ ---");
        System.out.println("Кот мяукает " + myCat.getMeowCount() + " раз");

        System.out.println("\n\n─── ДЕМОНСТРАЦИЯ С НЕСКОЛЬКИМИ КОТАМИ ───\n");

        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Барсик");
        Cat cat3 = new Cat("Тигра");

        System.out.println("Созданы коты: " + cat1.getName() + ", " + cat2.getName() + ", " + cat3.getName());
        System.out.println("\nПередаем всех котов в метод makeThemMeow():\n");

        Meowable[] allCats = { cat1, cat2, cat3 };
        makeThemMeow(allCats);

        System.out.println("\n--- РЕЗУЛЬТАТЫ ---");
        System.out.println(cat1.getName() + " мяукает " + cat1.getMeowCount() + " раз");
        System.out.println(cat2.getName() + " мяукает " + cat2.getMeowCount() + " раз");
        System.out.println(cat3.getName() + " мяукает " + cat3.getMeowCount() + " раз");
    }

    private void makeThemMeow(Meowable[] meowables) {
        for (Meowable meowable : meowables) {
            meowable.meow();
        }
    }
}