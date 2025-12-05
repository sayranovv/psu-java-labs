import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2_2 {

    public static void execute() {

        try {
            System.out.println("\n### Поиск максимума в коробках ###\n");

            System.out.println("▶ ДЕМОНСТРАЦИЯ 1: Коробки с Integer");
            System.out.println("═".repeat(50));

            List<Box<Integer>> intBoxes = new ArrayList<>();

            Box<Integer> box1 = new Box<>();
            box1.put(5);
            intBoxes.add(box1);

            Box<Integer> box2 = new Box<>();
            box2.put(12);
            intBoxes.add(box2);

            Box<Integer> box3 = new Box<>();
            box3.put(8);
            intBoxes.add(box3);

            Box<Integer> box4 = new Box<>();
            box4.put(20);
            intBoxes.add(box4);

            Box<Integer> box5 = new Box<>();
            box5.put(3);
            intBoxes.add(box5);

            System.out.println("Коробки с целыми числами:");
            for (int i = 0; i < intBoxes.size(); i++) {
                Box<Integer> b = intBoxes.get(i);

                if (!b.isEmpty()) {
                    System.out.println("  Коробка " + (i + 1) + ": " + b);
                }
            }

            double maxInt = findMax(intBoxes);
            System.out.println("Максимальное значение: " + maxInt);

            System.out.println("\n▶ ДЕМОНСТРАЦИЯ 2: Коробки с Double");
            System.out.println("═".repeat(50));

            List<Box<Double>> doubleBoxes = new ArrayList<>();

            Box<Double> dbox1 = new Box<>();
            dbox1.put(3.14);
            doubleBoxes.add(dbox1);

            Box<Double> dbox2 = new Box<>();
            dbox2.put(2.71);
            doubleBoxes.add(dbox2);

            Box<Double> dbox3 = new Box<>();
            dbox3.put(1.41);
            doubleBoxes.add(dbox3);

            Box<Double> dbox4 = new Box<>();
            dbox4.put(1.73);
            doubleBoxes.add(dbox4);

            System.out.println("Коробки с вещественными числами:");
            for (int i = 0; i < doubleBoxes.size(); i++) {
                Box<Double> b = doubleBoxes.get(i);
                if (!b.isEmpty()) {
                    System.out.println("  Коробка " + (i + 1) + ": " + b);
                }
            }

            double maxDouble = findMax(doubleBoxes);
            System.out.println("Максимальное значение: " + maxDouble);

            System.out.println("\n▶ ДЕМОНСТРАЦИЯ 3: Коробки с Long");
            System.out.println("═".repeat(50));

            List<Box<Long>> longBoxes = new ArrayList<>();

            Box<Long> lbox1 = new Box<>();
            lbox1.put(1000000L);
            longBoxes.add(lbox1);

            Box<Long> lbox2 = new Box<>();
            lbox2.put(5000000L);
            longBoxes.add(lbox2);

            Box<Long> lbox3 = new Box<>();
            lbox3.put(3000000L);
            longBoxes.add(lbox3);

            System.out.println("Коробки с длинными целыми числами:");
            for (int i = 0; i < longBoxes.size(); i++) {
                Box<Long> b = longBoxes.get(i);
                if (!b.isEmpty()) {
                    System.out.println("  Коробка " + (i + 1) + ": " + b);
                }
            }

            double maxLong = findMax(longBoxes);
            System.out.println("Максимальное значение: " + maxLong);

            System.out.println("\n▶ ДЕМОНСТРАЦИЯ 4: Обработка пустого списка");
            System.out.println("═".repeat(50));

            List<Box<Integer>> emptyBoxes = new ArrayList<>();
            System.out.println("Пустой список коробок");

            try {
                double maxEmpty = findMax(emptyBoxes);
                System.out.println("Максимальное значение: " + maxEmpty);
            } catch (IllegalArgumentException e) {
                System.out.println("Поймано исключение: " + e.getMessage());
            }

            System.out.println("\n" + "═".repeat(50));
            System.out.println("▶ ИНТЕРАКТИВНАЯ ЧАСТЬ");
            System.out.println("═".repeat(50));

            System.out.println("\nВыберите тип коробок:");
            System.out.println("  1 - Integer");
            System.out.println("  2 - Double");
            System.out.println("  3 - Long");
            System.out.print("\nВаш выбор: ");

            int choice = Main.getIntInput("");

            switch (choice) {
                case 1:
                    interactiveIntegerBoxes();
                    break;
                case 2:
                    interactiveDoubleBoxes();
                    break;
                case 3:
                    interactiveLongBoxes();
                    break;
                default:
                    System.out.println("Неправильный выбор");
            }

            System.out.println("\nЗадача 2.2 завершена!");

        } catch (Exception e) {
            System.out.println("Ошибка выполнения: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static <T extends Number> double findMax(List<Box<T>> boxes) {
        if (boxes == null || boxes.isEmpty()) {
            throw new IllegalArgumentException("Ошибка: список коробок не может быть пустым!");
        }

        double max = Double.NEGATIVE_INFINITY;

        for (Box<T> box : boxes) {
            T value = box.get();

            if (value != null) {
                double doubleValue = value.doubleValue();
                if (doubleValue > max) {
                    max = doubleValue;
                }
            }
        }

        return max;
    }

    private static void interactiveIntegerBoxes() {
        System.out.println("\n### Интерактивный поиск максимума для Integer ###\n");

        System.out.print("Введите количество коробок: ");
        int count = Main.getIntInput("");

        if (count <= 0) {
            System.out.println("Количество должно быть положительным числом");
            return;
        }

        List<Box<Integer>> boxes = new ArrayList<>();

        System.out.println("\nВводите целые числа для размещения в коробках:");
        for (int i = 0; i < count; i++) {
            System.out.print("  Число " + (i + 1) + ": ");
            int num = Main.getIntInput("");

            Box<Integer> box = new Box<>();
            box.put(num);
            boxes.add(box);
        }

        double max = findMax(boxes);
        System.out.println("\nМаксимальное значение: " + max);
    }

    private static void interactiveDoubleBoxes() {
        System.out.println("\n### Интерактивный поиск максимума для Double ###\n");

        System.out.print("Введите количество коробок: ");
        int count = Main.getIntInput("");

        if (count <= 0) {
            System.out.println("Количество должно быть положительным числом");
            return;
        }

        List<Box<Double>> boxes = new ArrayList<>();

        System.out.println("\nВводите вещественные числа для размещения в коробках:");
        for (int i = 0; i < count; i++) {
            System.out.print("  Число " + (i + 1) + ": ");
            double num = Main.getDoubleInput("");

            Box<Double> box = new Box<>();
            box.put(num);
            boxes.add(box);
        }

        double max = findMax(boxes);
        System.out.println("\nМаксимальное значение: " + max);
    }

    private static void interactiveLongBoxes() {
        System.out.println("\n### Интерактивный поиск максимума для Long ###\n");

        System.out.print("Введите количество коробок: ");
        int count = Main.getIntInput("");

        if (count <= 0) {
            System.out.println("Количество должно быть положительным числом");
            return;
        }

        List<Box<Long>> boxes = new ArrayList<>();

        System.out.println("\nВводите длинные целые числа для размещения в коробках:");
        for (int i = 0; i < count; i++) {
            System.out.print("  Число " + (i + 1) + ": ");

            Scanner scanner = new Scanner(System.in);
            try {
                long num = Long.parseLong(scanner.nextLine().trim());

                Box<Long> box = new Box<>();
                box.put(num);
                boxes.add(box);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введено не длинное целое число");
                i--;
            }
        }

        double max = findMax(boxes);
        System.out.println("\nМаксимальное значение: " + max);
    }
}