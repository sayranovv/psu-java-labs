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
            
            System.out.println("\n" + "═".repeat(50));
            System.out.println("▶ ИНТЕРАКТИВНАЯ ЧАСТЬ");
            System.out.println("═".repeat(50));
            
            System.out.println("\nВыберите операцию сокращения:");
            System.out.println("  1 - Суммирование чисел");
            System.out.println("  2 - Произведение чисел");
            System.out.println("  3 - Конкатенация строк");
            System.out.println("  4 - Поиск максимума");
            System.out.print("\nВаш выбор: ");
            
            int choice = Main.getIntInput("");

            switch (choice) {
                case 1:
                    interactiveSum();
                    break;
                case 2:
                    interactiveProduct();
                    break;
                case 3:
                    interactiveConcatenation();
                    break;
                case 4:
                    interactiveMax();
                    break;
                default:
                    System.out.println("Неправильный выбор");
            }
            
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
    
    private static void interactiveSum() {
        System.out.println("\n### Интерактивное суммирование ###\n");
        
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
        
        Reducer<Integer> sum = (acc, value) -> acc + value;
        Integer result = reduce(numbers, 0, sum);
        
        System.out.println("\nИсходный список: " + numbers);
        System.out.println("Сумма: " + result);
    }

    private static void interactiveProduct() {
        System.out.println("\n### Интерактивное произведение ###\n");
        
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
        
        Reducer<Integer> product = (acc, value) -> acc * value;
        Integer result = reduce(numbers, 1, product);
        
        System.out.println("\nИсходный список: " + numbers);
        System.out.println("Произведение: " + result);
    }

    private static void interactiveConcatenation() {
        System.out.println("\n### Интерактивная конкатенация строк ###\n");
        
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
        
        Reducer<String> concat = (acc, value) -> acc + value;
        String result = reduce(strings, "", concat);
        
        System.out.println("\nИсходный список: " + strings);
        System.out.println("Результат конкатенации: \"" + result + "\"");
    }

    private static void interactiveMax() {
        System.out.println("\n### Интерактивный поиск максимума ###\n");
        
        System.out.print("Введите количество чисел: ");
        int count = Main.getIntInput("");

        if (count <= 0) {
            System.out.println("✗ Количество должно быть положительным");
            return;
        }
        
        List<Integer> numbers = new ArrayList<>();
        System.out.println("\nВводите целые числа:");
        
        for (int i = 0; i < count; i++) {
            System.out.print("  Число " + (i + 1) + ": ");
            int num = Main.getIntInput("");
            numbers.add(num);
        }
        
        Reducer<Integer> max = (acc, value) -> (acc > value) ? acc : value;
        Integer result = reduce(numbers, Integer.MIN_VALUE, max);
        
        System.out.println("\nИсходный список: " + numbers);
        System.out.println("Максимальное значение: " + result);
    }
}
