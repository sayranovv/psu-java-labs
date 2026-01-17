package services;

import annotations.Cache;
import entities.CacheDemo;

import java.util.Arrays;

public class Task6Service {

    public void runTask6() {
        System.out.println("\n─── ЗАДАНИЕ 6: @Cache ───\n");
        Cache annotation = CacheDemo.class.getAnnotation(Cache.class);
        if (annotation == null) {
            System.out.println("Аннотация @Cache не найдена на классе CacheDemo.");
            return;
        }

        String[] regions = annotation.value();
        if (regions.length == 0) {
            System.out.println("Список кешируемых областей пуст.");
        } else {
            System.out.println("Кешируемые области: " + Arrays.toString(regions));
        }
    }
}
