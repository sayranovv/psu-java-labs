public class Task1_1 {

    public static void execute() {

        try {
            System.out.println("\n### Демонстрация обобщённой коробки ###\n");

            System.out.println("▶ Шаг 1: Создание коробки типа Box<Integer>");
            Box<Integer> intBox = new Box<>();
            System.out.println("✓ Коробка создана: " + intBox);

            System.out.println("\n▶ Шаг 2: Размещение числа 3 в коробке");
            intBox.put(3);
            System.out.println("✓ Число 3 помещено в коробку: " + intBox);

            System.out.println("\n▶ Шаг 3: Передача коробки в метод extractAndPrint()");
            extractAndPrint(intBox);
            System.out.println("✓ После извлечения коробка пуста: " + intBox);

            System.out.println("\n" + "=".repeat(50));
            System.out.println("### Дополнительная демонстрация: Коробка строк ###\n");

            System.out.println("▶ Создание коробки типа Box<String>");
            Box<String> stringBox = new Box<>();
            System.out.println("✓ Коробка создана: " + stringBox);

            System.out.println("\n▶ Размещение строки \"Привет, мир!\" в коробке");
            stringBox.put("Привет, мир!");
            System.out.println("✓ Строка помещена: " + stringBox);

            System.out.println("\n▶ Извлечение строки из коробки");
            extractAndPrint(stringBox);

            System.out.println("\n" + "=".repeat(50));
            System.out.println("### Дополнительная демонстрация: Коробка Double ###\n");

            System.out.println("▶ Создание коробки типа Box<Double>");
            Box<Double> doubleBox = new Box<>();
            System.out.println("✓ Коробка создана: " + doubleBox);

            System.out.println("\n▶ Размещение числа 3.14159 в коробке");
            doubleBox.put(3.14159);
            System.out.println("✓ Число помещено: " + doubleBox);

            System.out.println("\n▶ Извлечение числа из коробки");
            extractAndPrint(doubleBox);

            System.out.println("\n" + "=".repeat(50));
            System.out.println("### Демонстрация обработки ошибок ###\n");

            Box<Integer> testBox = new Box<>();
            System.out.println("▶ Коробка создана: " + testBox);
            System.out.println("▶ Размещение значения 42");
            testBox.put(42);
            System.out.println("✓ Значение размещено: " + testBox);

            System.out.println("\n▶ Попытка размещения ещё одного значения в непустую коробку:");
            try {
                testBox.put(99);
            } catch (IllegalStateException e) {
                System.out.println("✗ Поймано исключение: " + e.getMessage());
            }

            System.out.println("\n▶ Извлечение значения из коробки");
            Integer value = testBox.get();
            System.out.println("✓ Извлечённое значение: " + value);
            System.out.println("✓ Коробка после извлечения: " + testBox);

            System.out.println("\n▶ Теперь можно размещать новое значение:");
            testBox.put(55);
            System.out.println("✓ Новое значение размещено: " + testBox);


            System.out.println("\nЗадача 1.1 завершена!");

        } catch (Exception e) {
            System.out.println("Ошибка выполнения: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static <T> void extractAndPrint(Box<T> box) {
        T value = box.get();

        if (value == null) {
            System.out.println("ℹ Коробка была пуста");
        } else {
            System.out.println("✓ Извлечённое значение: " + value);
            System.out.println("  Тип значения: " + value.getClass().getSimpleName());
        }
    }

}