package services;

import annotations.Validate;
import entities.ValidateDemo;

/**
 * Сервис читает аннотацию @Validate и выводит список указанных классов-валидаторов.
 */
public class Task4Service {

    /**
     * Получает аннотацию с класса ValidateDemo и печатает каждый тип из массива value().
     */
    public void runTask4() {
        System.out.println("\n─── ЗАДАНИЕ 4: @Validate ───\n");
        Validate annotation = ValidateDemo.class.getAnnotation(Validate.class);
        if (annotation == null) {
            System.out.println("Аннотация @Validate не найдена на классе ValidateDemo.");
            return;
        }
        System.out.println("Найденные классы для валидации:");
        for (Class<?> validator : annotation.value()) {
            System.out.println(" - " + validator.getName());
        }
    }
}
