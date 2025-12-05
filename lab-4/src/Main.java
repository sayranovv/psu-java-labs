import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║          ЛАБОРАТОРНАЯ РАБОТА 2          ║");
        System.out.println("╚═════════════════════════════════════════╝");

        boolean running = true;
        while (running) {
            displayMainMenu();
            
            int taskNumber = getIntInput("Введите номер задания (1-3, 0 для выхода): ");
            
            if (taskNumber == 0) {
                System.out.println("\nПрограмма завершена :)");
                running = false;
                break;
            }
            
            switch (taskNumber) {
                case 1:
                    handleTask1();
                    break;
                case 2:
                    handleTask2();
                    break;
                case 3:
                    handleTask3();
                    break;
                default:
                    System.out.println("✗ Ошибка: задание с номером " + taskNumber + " не найдено.");
                    System.out.println("   Допустимые номера заданий: 1, 2, 3.");
            }
            
            System.out.println("\n" + "=".repeat(60) + "\n");
        }
        
        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("\n┌──────────────────────────────────────────────────┐");
        System.out.println("│ ВЫБЕРИТЕ ЗАДАНИЕ:                                │");
        System.out.println("├──────────────────────────────────────────────────┤");
        System.out.println("│ 1. Обобщённые типы. Типовые переменные, <>       │");
        System.out.println("│    • Задача 1.1: Обобщённая коробка              │");
        System.out.println("│    • Задача 1.3: Сравнимое (интерфейс)           │");
        System.out.println("│                                                  │");
        System.out.println("│ 2. Параметризация. Маски типов и их ограничения  │");
        System.out.println("│    • Задача 2.2: Поиск максимума                 │");
        System.out.println("│                                                  │");
        System.out.println("│ 3. Обобщённые методы. Автовывод типа             │");
        System.out.println("│    • Задача 3.1: Функция (map)                   │");
        System.out.println("│    • Задача 3.2: Фильтр (filter)                 │");
        System.out.println("│    • Задача 3.3: Сокращение (reduce)             │");
        System.out.println("│    • Задача 3.4: Коллекционирование (collect)    │");
        System.out.println("│                                                  │");
        System.out.println("│ 0. Выход                                         │");
        System.out.println("└──────────────────────────────────────────────────┘");
    }

    private static void handleTask1() {
        System.out.println("\n>>> ЗАДАНИЕ 1: Обобщённые типы. Типовые переменные, <>");
        System.out.println("├─ Задача 1.1: Обобщённая коробка");
        System.out.println("└─ Задача 1.3: Сравнимое\n");
        
        int subtask = getIntInput("Выберите задачу (1 для 1.1, 3 для 1.3): ");
        
        if (subtask == 1) {
            System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
            System.out.println("║                    ЗАДАЧА 1.1: ОБОБЩЁННАЯ КОРОБКА               ║");
            System.out.println("╚════════════════════════════════════════════════════════════════╝");
            Task1_1.execute();
        } else if (subtask == 3) {
            System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
            System.out.println("║                    ЗАДАЧА 1.3: СРАВНИМОЕ                       ║");
            System.out.println("╚════════════════════════════════════════════════════════════════╝");
            Task1_3.execute();
        } else {
            System.out.println("✗ Ошибка: задача с номером " + subtask + " не найдена в Задании 1.");
        }
    }

    private static void handleTask2() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║       ЗАДАНИЕ 2: Параметризация. Маски типов и ограничения    ║");
        System.out.println("║                    ЗАДАЧА 2.2: ПОИСК МАКСИМУМА                 ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        Task2_2.execute();
    }

    private static void handleTask3() {
        System.out.println("\n>>> ЗАДАНИЕ 3: Обобщённые методы. Автовывод типа");
        System.out.println("├─ Задача 3.1: Функция (map)");
        System.out.println("├─ Задача 3.2: Фильтр (filter)");
        System.out.println("├─ Задача 3.3: Сокращение (reduce)");
        System.out.println("└─ Задача 3.4: Коллекционирование (collect)\n");
        
        int subtask = getIntInput("Выберите задачу (1, 2, 3 или 4): ");
        
        switch (subtask) {
            case 1:
                System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
                System.out.println("║                   ЗАДАЧА 3.1: ФУНКЦИЯ (MAP)                     ║");
                System.out.println("╚════════════════════════════════════════════════════════════════╝");
                Task3_1.execute();
                break;
            case 2:
                System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
                System.out.println("║                  ЗАДАЧА 3.2: ФИЛЬТР (FILTER)                    ║");
                System.out.println("╚════════════════════════════════════════════════════════════════╝");
                Task3_2.execute();
                break;
            case 3:
                System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
                System.out.println("║                 ЗАДАЧА 3.3: СОКРАЩЕНИЕ (REDUCE)                 ║");
                System.out.println("╚════════════════════════════════════════════════════════════════╝");
                Task3_3.execute();
                break;
            case 4:
                System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
                System.out.println("║              ЗАДАЧА 3.4: КОЛЛЕКЦИОНИРОВАНИЕ (COLLECT)           ║");
                System.out.println("╚════════════════════════════════════════════════════════════════╝");
                Task3_4.execute();
                break;
            default:
                System.out.println("✗ Ошибка: задача с номером " + subtask + " не найдена в Задании 3.");
        }
    }

    public static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                if (scanner.hasNextInt()) {
                    int value = scanner.nextInt();
                    scanner.nextLine();
                    return value;
                } else {
                    System.out.println("✗ Ошибка: введено не целое число. Пожалуйста, попробуйте снова.");
                    scanner.nextLine();
                }
            } catch (Exception e) {
                System.out.println("✗ Ошибка ввода: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

}
