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


            System.out.println("\n" + "═".repeat(50));
            System.out.println("▶ ИНТЕРАКТИВНАЯ ЧАСТЬ");
            System.out.println("═".repeat(50));
            
            System.out.println("\nВыберите тип преобразования:");
            System.out.println("  1 - Строки в длины");
            System.out.println("  2 - Числа в абсолютные значения");
            System.out.println("  3 - Числа в их квадраты");
            System.out.print("\nВаш выбор: ");
            
            int choice = Main.getIntInput("");

            switch (choice) {
                case 1:
                    interactiveStringToLength();
                    break;
                case 2:
                    interactiveNumbersToAbsolute();
                    break;
                case 3:
                    interactiveNumbersToSquares();
                    break;
                default:
                    System.out.println("Неправильный выбор");
            }
            
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
    
    private static void interactiveStringToLength() {
        System.out.println("\n### Интерактивное преобразование строк в длины ###\n");
        
        System.out.print("Введите количество строк: ");
        int count = Main.getIntInput("");

        if (count <= 0) {
            System.out.println("Количество должно быть положительным");
            return;
        }
        
        List<String> strings = new ArrayList<>();
        System.out.println("\nВводите строки:");
        
        for (int i = 0; i < count; i++) {
            System.out.print("  Строка " + (i + 1) + ": ");
            String str = Main.getStringInput("");
            if (!str.isEmpty()) {
                strings.add(str);
            }
        }
        
        Function<String, Integer> stringLength = String::length;
        List<Integer> lengths = map(strings, stringLength);
        
        System.out.println("\nИсходные строки: " + strings);
        System.out.println("Длины строк: " + lengths);
    }
    
    private static void interactiveNumbersToAbsolute() {
        System.out.println("\n### Интерактивное преобразование чисел в абсолютные значения ###\n");
        
        System.out.print("Введите количество чисел: ");
        int count = Main.getIntInput("");

        if (count <= 0) {
            System.out.println("Количество должно быть положительным");
            return;
        }
        
        List<Integer> numbers = new ArrayList<>();
        System.out.println("\nВводите целые числа:");
        
        for (int i = 0; i < count; i++) {
            System.out.print("  Число " + (i + 1) + ": ");
            int num = Main.getIntInput("");
            numbers.add(num);
        }
        
        Function<Integer, Integer> absolute = num -> Math.abs(num);
        List<Integer> absoluteValues = map(numbers, absolute);
        
        System.out.println("\nИсходные числа: " + numbers);
        System.out.println("Абсолютные значения: " + absoluteValues);
    }
    
    private static void interactiveNumbersToSquares() {
        System.out.println("\n### Интерактивное преобразование чисел в квадраты ###\n");
        
        System.out.print("Введите количество чисел: ");
        int count = Main.getIntInput("");

        if (count <= 0) {
            System.out.println("Количество должно быть положительным");
            return;
        }
        
        List<Integer> numbers = new ArrayList<>();
        System.out.println("\nВводите целые числа:");
        
        for (int i = 0; i < count; i++) {
            System.out.print("  Число " + (i + 1) + ": ");
            int num = Main.getIntInput("");
            numbers.add(num);
        }
        
        Function<Integer, Integer> square = num -> num * num;
        List<Integer> squares = map(numbers, square);
        
        System.out.println("\nИсходные числа: " + numbers);
        System.out.println("Квадраты чисел: " + squares);
    }
}
