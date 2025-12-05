import java.util.ArrayList;
import java.util.List;

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
}