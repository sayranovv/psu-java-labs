import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task3_2 {

    public static void execute() {

        try {
            System.out.println("\n### Обобщённый метод filter (фильтрация) ###\n");
            
            System.out.println("▶ ДЕМОНСТРАЦИЯ 1: Строки с длиной >= 3");
            System.out.println("═".repeat(50));
            
            List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
            System.out.println("Исходный список строк: " + strings);
            
            Predicate<String> longStrings = str -> str.length() >= 3;
            
            List<String> filtered = filter(strings, longStrings);
            System.out.println("Результат (только строки с >= 3 символов): " + filtered);
            
            System.out.println("\n▶ ДЕМОНСТРАЦИЯ 2: Только положительные числа");
            System.out.println("═".repeat(50));
            
            List<Integer> numbers = Arrays.asList(1, -3, 7, -2, 5);
            System.out.println("Исходный список чисел: " + numbers);
            
            Predicate<Integer> positive = num -> num > 0;
            
            List<Integer> filteredPositive = filter(numbers, positive);
            System.out.println("Результат (только положительные): " + filteredPositive);
            
            System.out.println("\n▶ ДЕМОНСТРАЦИЯ 3: Массивы только с отрицательными числами");
            System.out.println("═".repeat(50));
            
            List<int[]> arrays = Arrays.asList(
                new int[]{-1, -5, -3},
                new int[]{2, 8, 4},
                new int[]{-7, -2, -9},
                new int[]{-1, 5, -3}
            );
            
            System.out.println("Исходный список массивов:");
            for (int i = 0; i < arrays.size(); i++) {
                System.out.println("  Массив " + (i + 1) + ": " + Arrays.toString(arrays.get(i)));
            }
            
            Predicate<int[]> allNegative = arr -> {
                for (int num : arr) {
                    if (num >= 0) {
                        return false;
                    }
                }
                return true;
            };
            
            List<int[]> filteredArrays = filter(arrays, allNegative);
            System.out.println("Результат (только массивы с отрицательными): ");
            for (int i = 0; i < filteredArrays.size(); i++) {
                System.out.println("  Массив " + (i + 1) + ": " + Arrays.toString(filteredArrays.get(i)));
            }
            
            System.out.println("\nЗадача 3.2 завершена!");
            
        } catch (Exception e) {
            System.out.println("Ошибка выполнения: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static <T> List<T> filter(List<T> source, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        
        for (T element : source) {
            if (predicate.test(element)) {
                result.add(element);
            }
        }
        
        return result;
    }

}
