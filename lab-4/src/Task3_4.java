import java.util.*;

public class Task3_4 {

    public static void execute() {

        try {
            System.out.println("\n### Обобщённый метод collect (коллекционирование) ###\n");

            System.out.println("▶ ДЕМОНСТРАЦИЯ 1: Разделение на положительные/отрицательные");
            System.out.println("═".repeat(50));

            List<Integer> numbers = Arrays.asList(1, -3, 7, -2, 5);
            System.out.println("Исходный список чисел: " + numbers);

            List<List<Integer>> groups = collect(
                    numbers,
                    () -> {
                        List<List<Integer>> res = new ArrayList<>();
                        res.add(new ArrayList<>());
                        res.add(new ArrayList<>());
                        return res;
                    },
                    (lists, elem) -> {
                        if (elem > 0) {
                            lists.get(0).add(elem);
                        } else if (elem < 0) {
                            lists.get(1).add(elem);
                        }
                    }
            );

            System.out.println("Результат:");
            System.out.println("Положительные: " + groups.get(0));
            System.out.println("Отрицательные: " + groups.get(1));

            System.out.println("\n▶ ДЕМОНСТРАЦИЯ 2: Разделение строк по длине");
            System.out.println("═".repeat(50));

            List<String> strings = Arrays.asList("qwerty", "asdfg", "zx", "qw");
            System.out.println("Исходный список строк: " + strings);

            Map<Integer, List<String>> byLength = collect(
                    strings,
                    HashMap::new,
                    (map, s) -> {
                        int len = s.length();
                        map.computeIfAbsent(len, k -> new ArrayList<>())
                                .add(s);
                    }
            );

            System.out.println("Результат группировки по длине:");
            byLength.forEach((len, list) ->
                    System.out.println("Длина " + len + ": " + list)
            );

            System.out.println("\n▶ ДЕМОНСТРАЦИЯ 3: Уникальные строки (Set)");
            System.out.println("═".repeat(50));

            List<String> stringsWithDuplicates = Arrays.asList("qwerty", "asdfg", "qwerty", "qw");
            System.out.println("Исходный список (с дубликатами): " + stringsWithDuplicates);

            Set<String> unique = collect(
                    stringsWithDuplicates,
                    HashSet::new,
                    Set::add
            );

            System.out.println("Результат: Уникальные значения: " + unique);

            System.out.println("\nЗадача 3.4 завершена!");

        } catch (Exception e) {
            System.out.println("Ошибка выполнения: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static <T, P> P collect(List<T> source, CollectionSupplier<P> supplier, Collector<T, P> collector) {

        P collection = supplier.create();

        for (T element : source) {
            collector.collect(collection, element);
        }

        return collection;
    }

}
