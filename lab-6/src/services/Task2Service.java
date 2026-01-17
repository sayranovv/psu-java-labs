package services;

import annotations.Default;
import entities.DefaultDemo;

public class Task2Service {

    public void runTask2() {
        System.out.println("\n─── ЗАДАНИЕ 2: @Default ───\n");
        Default annotation = DefaultDemo.class.getAnnotation(Default.class);
        if (annotation != null) {
            System.out.println("Аннотация @Default обнаружена.");
            System.out.println("Класс по умолчанию: " + annotation.value().getName());
        } else {
            System.out.println("Аннотация @Default отсутствует на классе DefaultDemo.");
        }
    }
}
