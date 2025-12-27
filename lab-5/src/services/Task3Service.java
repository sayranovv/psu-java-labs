package services;

import java.util.*;

public class Task3Service {

    public void runTask3() {
        List<Integer> list = new ArrayList<>();
        System.out.println("─── СОЗДАНИЕ И ЗАПОЛНЕНИЕ СПИСКА ───\n");

        int[] initialValues = {1, 2, 5, 3, 5, 4, 5, 6, 5, 7};
        for (int value : initialValues) {
            list.add(value);
        }

        System.out.println("Исходный список: " + list);
        System.out.println("Элементов в списке: " + list.size());

        int valueToRemove = 5;
        int countToRemove = 0;
        for (int value : list) {
            if (value == valueToRemove) {
                countToRemove++;
            }
        }

        System.out.println("\n─── УДАЛЕНИЕ ЭЛЕМЕНТОВ ───\n");
        System.out.println("Требуется удалить все элементы со значением: " + valueToRemove);
        System.out.println("Найдено элементов для удаления: " + countToRemove);

        System.out.println("\nУдаляем элементы...");
        removeAllOccurrences(list, valueToRemove);

        System.out.println("\n─── РЕЗУЛЬТАТ ───\n");
        System.out.println("Список после удаления: " + list);
        System.out.println("Осталось элементов: " + list.size());
    }

    private <T> void removeAllOccurrences(List<T> list, T value) {
        Iterator<T> iterator = list.iterator();

        while (iterator.hasNext()) {
            T element = iterator.next();

            if ((element == null && value == null) || (element != null && element.equals(value))) {
                iterator.remove();
            }
        }
    }
}