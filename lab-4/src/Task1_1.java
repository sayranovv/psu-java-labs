import java.util.Scanner;

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


            System.out.println("\n" + "=".repeat(50));
            System.out.println("### Интерактивная работа с коробкой ###\n");

            System.out.println("▶ Введите тип данных для работы:");
            System.out.println("  1 - Integer");
            System.out.println("  2 - String");
            System.out.println("  3 - Double");
            System.out.print("Ваш выбор: ");

            int choice = Main.getIntInput("");

            switch (choice) {
                case 1:
                    interactiveIntegerBox();
                    break;
                case 2:
                    interactiveStringBox();
                    break;
                case 3:
                    interactiveDoubleBox();
                    break;
                default:
                    System.out.println("✗ Некорректный выбор: " + choice);
            }

            System.out.println("\n✓ Задача 1.1 завершена!");

        } catch (Exception e) {
            System.out.println("✗ Ошибка выполнения: " + e.getMessage());
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

    private static void interactiveIntegerBox() {
        System.out.println("\n### Интерактивная коробка для целых чисел ###");

        Box<Integer> box = new Box<>();
        System.out.println("✓ Пуста коробка создана: " + box);

        System.out.print("Введите целое число: ");
        int number = Main.getIntInput("");

        box.put(number);
        System.out.println("✓ Число помещено в коробку: " + box);

        System.out.print("Нажмите Enter для извлечения значения...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        Integer extracted = box.get();
        System.out.println("✓ Извлечённое значение: " + extracted);
        System.out.println("✓ Коробка после извлечения: " + box);
    }

    private static void interactiveStringBox() {
        System.out.println("\n### Интерактивная коробка для строк ###");

        Box<String> box = new Box<>();
        System.out.println("✓ Пуста коробка создана: " + box);

        System.out.print("Введите текст: ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine().trim();

        if (text.isEmpty()) {
            System.out.println("✗ Текст не может быть пустым");
            return;
        }

        box.put(text);
        System.out.println("✓ Текст помещён в коробку: " + box);

        System.out.print("Нажмите Enter для извлечения значения...");
        scanner.nextLine();

        String extracted = box.get();
        System.out.println("✓ Извлечённый текст: " + extracted);
        System.out.println("✓ Коробка после извлечения: " + box);
    }

    private static void interactiveDoubleBox() {
        System.out.println("\n### Интерактивная коробка для вещественных чисел ###");

        Box<Double> box = new Box<>();
        System.out.println("✓ Пуста коробка создана: " + box);

        System.out.print("Введите вещественное число: ");
        double number = Main.getDoubleInput("");

        box.put(number);
        System.out.println("✓ Число помещено в коробку: " + box);

        System.out.print("Нажмите Enter для извлечения значения...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        Double extracted = box.get();
        System.out.println("✓ Извлечённое значение: " + extracted);
        System.out.println("✓ Коробка после извлечения: " + box);
    }

}