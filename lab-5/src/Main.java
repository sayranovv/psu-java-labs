import services.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        printWelcome();

        while (running) {
            printMenu();

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    runTask(new Task1Service(), "Задание 1: Шаблоны и кэширование");
                    break;
                case "2":
                    runTask(new Task2Service(), "Задание 2: Структурные шаблоны");
                    break;
                case "3":
                    runTask(new Task3Service(), "Задание 3: Очередь");
                    break;
                case "4":
                    runTask(new Task4Service(), "Задание 4: Мап");
                    break;
                case "5":
                    runTask(new Task5Service(), "Задание 5: Сет");
                    break;
                case "6":
                    runTask(new Task6Service(), "Задание 6: Очередь");
                    break;
                case "7":
                    runTask(new Task7Service(), "Задание 7: Стрим");
                    break;
                case "0":
                    running = false;
                    System.out.println("\nПрограмма завершена :");
                    break;
                default:
                    System.out.println("\nНеверный выбор\n");
            }
        }

        scanner.close();
    }

    private static void printWelcome() {
        System.out.println("\n");
        System.out.println("╔═════════════════════════════════════════════════╗");
        System.out.println("║  ЛАБОРАТОРНАЯ РАБОТА №5: JAVA OOP И КОЛЛЕКЦИИ   ║");
        System.out.println("╚═════════════════════════════════════════════════╝");
        System.out.println();
    }

    private static void printMenu() {
        System.out.println("╔═════════════════════════════════════════════════╗");
        System.out.println("║                  ГЛАВНОЕ МЕНЮ                   ║");
        System.out.println("╚═════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("  1 - Задание 1: Шаблоны и кэширование");
        System.out.println("  2 - Задание 2: Структурные шаблоны (коты)");
        System.out.println("  3 - Задание 3: Список - удаление элементов");
        System.out.println("  4 - Задание 4: Мап - олимпиада по информатике");
        System.out.println("  5 - Задание 5: Сет - согласные буквы");
        System.out.println("  6 - Задание 6: Очередь - проверка участка");
        System.out.println("  7 - Задание 7: Стрим - обработка данных");
        System.out.println("  0 - Выход");
        System.out.println();
        System.out.print("Выберите номер задания: ");
    }

    private static void runTask(Object service, String taskName) {
        try {
            if (service instanceof Task1Service) {
                ((Task1Service) service).runTask1();
            } else if (service instanceof Task2Service) {
                ((Task2Service) service).runTask2();
            } else if (service instanceof Task3Service) {
                ((Task3Service) service).runTask3();
            } else if (service instanceof Task4Service) {
                ((Task4Service) service).runTask4();
            } else if (service instanceof Task5Service) {
                ((Task5Service) service).runTask5();
            } else if (service instanceof Task6Service) {
                ((Task6Service) service).runTask6();
            } else if (service instanceof Task7Service) {
                ((Task7Service) service).runTask7();
            }

            System.out.println("\n╔════════════════════════════════════════════════════════════╗");
            System.out.println("║    Задание выполнено. Нажмите ENTER для возврата в меню    ║");
            System.out.println("╚════════════════════════════════════════════════════════════╝\n");

            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();

        } catch (Exception e) {
            System.out.println("\nОшибка при выполнении задания: " + e.getMessage());
            e.printStackTrace();
        }
    }
}