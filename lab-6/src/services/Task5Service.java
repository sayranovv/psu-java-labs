package services;

import annotations.Two;
import entities.TwoDemo;

/**
 * Сервис считывает значения аннотации @Two с класса и выводит их в консоль.
 */
public class Task5Service {

    /**
     * Получает @Two у TwoDemo и печатает свойства first и second либо сообщает об отсутствии аннотации.
     */
    public void runTask5() {
        System.out.println("\n─── ЗАДАНИЕ 5: @Two ───\n");
        Two annotation = TwoDemo.class.getAnnotation(Two.class);
        if (annotation == null) {
            System.out.println("Аннотация @Two отсутствует на классе TwoDemo.");
            return;
        }
        System.out.println("Свойство first: " + annotation.first());
        System.out.println("Свойство second: " + annotation.second());
    }
}
