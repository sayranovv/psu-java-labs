package services;

import annotations.Two;
import entities.TwoDemo;

public class Task5Service {

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
