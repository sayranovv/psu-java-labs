package services;

import annotations.Invoke;
import entities.InvokeDemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Сервис для задания 1: ищет и вызывает методы, помеченные @Invoke.
 */
public class Task1Service {

    /**
     * Демонстрация: создаем объект, вызываем все методы с @Invoke и печатаем результаты/флаг.
     */
    public void runTask1() {
        System.out.println("\n─── ЗАДАНИЕ 1: @Invoke ───\n");
        InvokeDemo demo = new InvokeDemo();
        List<Object> results = invokeAnnotatedMethods(demo);

        System.out.println("Вызваны методы с @Invoke. Количество результатов: " + results.size());
        for (Object result : results) {
            System.out.println("  -> результат: " + result);
        }
        System.out.println("Флаг вызова внутри объекта: " + demo.wasInvoked());
    }

    /**
     * Обходит все методы целевого объекта, вызывает только те, что помечены @Invoke.
     * Возвращает список значений, которые вернули вызванные методы.
     *
     * @param target объект, на котором ищем методы
     * @return список результатов вызовов
     */
    public List<Object> invokeAnnotatedMethods(Object target) {
        List<Object> results = new ArrayList<>();
        if (target == null) {
            return results;
        }

        Class<?> clazz = target.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Invoke.class)) {
                try {
                    method.setAccessible(true); // даем доступ к приватным методам ради демонстрации
                    Object result = method.invoke(target);
                    results.add(result);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new IllegalStateException("Не удалось вызвать метод " + method.getName(), e);
                }
            }
        }
        return results;
    }
}
