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


            System.out.println("\n" + "═".repeat(50));
            System.out.println("▶ ИНТЕРАКТИВНАЯ ЧАСТЬ");
            System.out.println("═".repeat(50));
            
            System.out.println("\nВыберите тип фильтрации:");
            System.out.println("  1 - Строки (минимальная длина)");
            System.out.println("  2 - Числа (четные/нечетные)");
            System.out.println("  3 - Числа (больше заданного значения)");
            System.out.print("\nВаш выбор: ");
            
            int choice = Main.getIntInput("");

            switch (choice) {
                case 1:
                    interactiveFilterStrings();
                    break;
                case 2:
                    interactiveFilterNumbers();
                    break;
                case 3:
                    interactiveFilterNumbersGreater();
                    break;
                default:
                    System.out.println("Неправильный выбор");
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
    
    private static void interactiveFilterStrings() {
        System.out.println("\n### Интерактивная фильтрация строк ###\n");
        
        System.out.print("Введите минимальную длину строки: ");
        int minLength = Main.getIntInput("");

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
        
        Predicate<String> minLengthFilter = str -> str.length() >= minLength;
        List<String> filtered = filter(strings, minLengthFilter);
        
        System.out.println("\nИсходные строки: " + strings);
        System.out.println("Отфильтрованные (длина >= " + minLength + "): " + filtered);
    }
    
    private static void interactiveFilterNumbers() {
        System.out.println("\n### Интерактивная фильтрация чисел ###\n");
        
        System.out.println("Выберите тип фильтрации:");
        System.out.println("  1 - Четные числа");
        System.out.println("  2 - Нечетные числа");
        System.out.print("Ваш выбор: ");
        
        int filterType = Main.getIntInput("");

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
        
        Predicate<Integer> filterPredicate;
        String filterName;
        
        if (filterType == 1) {
            filterPredicate = num -> num % 2 == 0;
            filterName = "четные";
        } else {
            filterPredicate = num -> num % 2 != 0;
            filterName = "нечетные";
        }
        
        List<Integer> filtered = filter(numbers, filterPredicate);
        
        System.out.println("\nИсходные числа: " + numbers);
        System.out.println("Отфильтрованные (" + filterName + "): " + filtered);
    }
    
    private static void interactiveFilterNumbersGreater() {
        System.out.println("\n### Интерактивная фильтрация чисел (> значения) ###\n");
        
        System.out.print("Введите пороговое значение: ");
        int threshold = Main.getIntInput("");

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
        
        Predicate<Integer> greaterThan = num -> num > threshold;
        List<Integer> filtered = filter(numbers, greaterThan);
        
        System.out.println("\nИсходные числа: " + numbers);
        System.out.println("Отфильтрованные (> " + threshold + "): " + filtered);
    }
}
