import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task3_1 {

    public static void execute() {

        try {
            System.out.println("\n### Обобщённый метод map (применение функции) ###\n");
            
            System.out.println("▶ ДЕМОНСТРАЦИЯ 1: Строки → Длины");
            System.out.println("═".repeat(50));
            
            List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
            System.out.println("Исходный список строк: " + strings);
            
            Function<String, Integer> stringLength = str -> str.length();
            
            List<Integer> lengths = map(strings, stringLength);
            System.out.println("Результат (длины строк): " + lengths);
            
            System.out.println("\n▶ ДЕМОНСТРАЦИЯ 2: Числа → Абсолютные значения");
            System.out.println("═".repeat(50));
            
            List<Integer> numbers = Arrays.asList(1, -3, 7);
            System.out.println("Исходный список чисел: " + numbers);
            
            Function<Integer, Integer> absolute = num -> {
                if (num < 0) {
                    return -num;
                } else {
                    return num;
                }
            };
            
            List<Integer> absValues = map(numbers, absolute);
            System.out.println("Результат (абсолютные значения): " + absValues);
            
            System.out.println("\n▶ ДЕМОНСТРАЦИЯ 3: Массивы → Максимальные значения");
            System.out.println("═".repeat(50));
            
            List<int[]> arrays = Arrays.asList(
                new int[]{1, 5, 3},
                new int[]{2, 8, 4},
                new int[]{7, 2, 9}
            );
            
            System.out.println("Исходный список массивов:");
            for (int i = 0; i < arrays.size(); i++) {
                System.out.println("  Массив " + (i + 1) + ": " + Arrays.toString(arrays.get(i)));
            }
            
            Function<int[], Integer> findMax = arr -> {
                int max = arr[0];

                for (int num : arr) {
                    if (num > max) {
                        max = num;
                    }
                }

                return max;
            };
            
            List<Integer> maxValues = map(arrays, findMax);
            System.out.println("Результат (максимальные значения): " + maxValues);
            
            System.out.println("\nЗадача 3.1 завершена!");
            
        } catch (Exception e) {
            System.out.println("Ошибка выполнения: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static <T, P> List<P> map(List<T> source, Function<T, P> function) {
        List<P> result = new ArrayList<>();
        
        for (T element : source) {
            P transformed = function.apply(element);
            result.add(transformed);
        }
        
        return result;
    }

}
