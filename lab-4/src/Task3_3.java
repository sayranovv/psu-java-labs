import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task3_3 {
    
    public static void execute() {

        try {
            System.out.println("\n### Обобщённый метод reduce (сокращение) ###\n");
            
            System.out.println("▶ ДЕМОНСТРАЦИЯ 1: Конкатенация строк");
            System.out.println("═".repeat(50));
            
            List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
            System.out.println("Исходный список строк: " + strings);
            
            Reducer<String> concatenate = (acc, value) -> acc + value;
            
            String result = reduce(strings, "", concatenate);
            System.out.println("Результат конкатенации: \"" + result + "\"");
            
            System.out.println("\n▶ ДЕМОНСТРАЦИЯ 2: Суммирование целых чисел");
            System.out.println("═".repeat(50));
            
            List<Integer> numbers = Arrays.asList(1, -3, 7);
            System.out.println("Исходный список чисел: " + numbers);
            
            Reducer<Integer> sum = (acc, value) -> acc + value;
            
            Integer total = reduce(numbers, 0, sum);
            System.out.println("Результат суммирования: " + total);
            
            System.out.println("\n▶ ДЕМОНСТРАЦИЯ 3: Подсчёт элементов в списке списков");
            System.out.println("═".repeat(50));
            
            List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
            );
            
            System.out.println("Исходный список списков:");
            for (int i = 0; i < listOfLists.size(); i++) {
                System.out.println("  Список " + (i + 1) + ": " + listOfLists.get(i));
            }
            
            int totalCount = 0;
            for (List<Integer> list : listOfLists) {
                totalCount += list.size();
            }
            System.out.println("Общее количество элементов: " + totalCount);
            
            System.out.println("\n▶ ДЕМОНСТРАЦИЯ 4: Пустой список");
            System.out.println("═".repeat(50));
            
            List<Integer> emptyList = new ArrayList<>();
            System.out.println("Пустой список: " + emptyList);
            
            Integer safeSum = reduceSafe(emptyList, 0, sum);
            System.out.println("Результат сокращения пустого списка: " + safeSum);
            
            System.out.println("\nЗадача 3.3 завершена!");
            
        } catch (Exception e) {
            System.out.println("Ошибка выполнения: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static <T> T reduce(List<T> source, T initial, Reducer<T> operation) {
        T accumulator = initial;
        
        for (T element : source) {
            accumulator = operation.reduce(accumulator, element);
        }
        
        return accumulator;
    }
    
    public static <T> T reduceSafe(List<T> source, T initial, Reducer<T> operation) {
        if (source == null || source.isEmpty()) {
            return initial;
        }
        
        return reduce(source, initial, operation);
    }

}
