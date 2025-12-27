package services;

import java.util.*;

public class Task6Service {

    public void runTask6() {
        Queue<Integer> queue = new LinkedList<>();

        int[] values = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        for (int value : values) {
            queue.add(value);
        }

        System.out.println("Очередь: " + queue);
        System.out.println("Размер очереди: " + queue.size());

        System.out.println("\n\n─── УЧАСТОК С I=2, J=5 ───\n");

        int i1 = 2;
        int j1 = 5;
        System.out.println("Проверяем участок с индекса " + i1 + " по индекс " + j1);

        List<Integer> queueList1 = new ArrayList<>(queue);

        System.out.println("\nЭлементы в очереди:");
        for (int idx = 0; idx < queueList1.size(); idx++) {
            String marker = (idx >= i1 && idx <= j1) ? " ← УЧАСТОК" : "";
            System.out.println("  [" + idx + "] = " + queueList1.get(idx) + marker);
        }

        List<Integer> segment1 = queueList1.subList(i1, j1 + 1);
        System.out.println("\nИзвлеченный участок: " + segment1);
        System.out.println("Элементы участка: " + String.join(", ", segment1.stream().map(String::valueOf).toArray(String[]::new)));

        System.out.println("\n\n─── УЧАСТОК С I=4, J=7 ───\n");

        int i2 = 4;
        int j2 = 7;
        System.out.println("Проверяем участок с индекса " + i2 + " по индекс " + j2);

        List<Integer> queueList2 = new ArrayList<>(queue);

        System.out.println("\nЭлементы в очереди:");
        for (int idx = 0; idx < queueList2.size(); idx++) {
            String marker = (idx >= i2 && idx <= j2) ? " ← УЧАСТОК" : "";
            System.out.println("  [" + idx + "] = " + queueList2.get(idx) + marker);
        }

        List<Integer> segment2 = queueList2.subList(i2, j2 + 1);
        System.out.println("\nИзвлеченный участок: " + segment2);
        System.out.println("Элементы участка: " + String.join(", ", segment2.stream().map(String::valueOf).toArray(String[]::new)));

        System.out.println("\n\n─── ПРОВЕРКА РАВЕНСТВА ───\n");

        System.out.println("Участок 1: " + segment1);
        System.out.println("Участок 2: " + segment2);

        boolean areEqual = segment1.equals(segment2);
        System.out.println("\nУчастки равны: " + areEqual);
    }
}