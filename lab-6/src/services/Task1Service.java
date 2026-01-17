package services;

import annotations.Invoke;
import entities.InvokeDemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Task1Service {

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

    public List<Object> invokeAnnotatedMethods(Object target) {
        List<Object> results = new ArrayList<>();
        if (target == null) {
            return results;
        }

        Class<?> clazz = target.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Invoke.class)) {
                try {
                    method.setAccessible(true);
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
