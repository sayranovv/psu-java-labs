import services.*;
import java.util.Scanner;

public class Main {
    /**
     * Точка входа: запускает консольное меню и маршрутизирует выполнение задач.
     */
    public static void main(String[] args) {
        // создаем сканер для чтения ввода пользователя
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        printWelcome();

        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    runTask(new Task1Service(), "Задание 1: @Invoke");
                    break;
                case "2":
                    runTask(new Task2Service(), "Задание 2: @Default");
                    break;
                case "3":
                    runTask(new Task3Service(), "Задание 3: @ToString");
                    break;
                case "4":
                    runTask(new Task4Service(), "Задание 4: @Validate");
                    break;
                case "5":
                    runTask(new Task5Service(), "Задание 5: @Two");
                    break;
                case "6":
                    runTask(new Task6Service(), "Задание 6: @Cache");
                    break;
                case "0":
                    running = false; // завершаем цикл и программу
                    System.out.println("\nПрограмма завершена.");
                    break;
                default:
                    System.out.println("\nНеверный выбор, повторите ввод.\n");
            }
        }
        scanner.close(); // освобождаем ресурс сканера
    }

    /**
     * Выводит приветственный баннер для пользователя.
     */
    private static void printWelcome() {
        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║  ЛАБОРАТОРНАЯ №6: АННОТАЦИИ И ТЕСТЫ  ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println();
    }

    /**
     * Показывает список доступных заданий и запрос на ввод.
     */
    private static void printMenu() {
        System.out.println("╔════════════════════════════╗");
        System.out.println("║          МЕНЮ              ║");
        System.out.println("╚════════════════════════════╝");
        System.out.println("  1 - Задание 1: @Invoke");
        System.out.println("  2 - Задание 2: @Default");
        System.out.println("  3 - Задание 3: @ToString");
        System.out.println("  4 - Задание 4: @Validate");
        System.out.println("  5 - Задание 5: @Two");
        System.out.println("  6 - Задание 6: @Cache");
        System.out.println("  0 - Выход");
        System.out.print("Ваш выбор: ");
    }

    /**
     * Выполняет выбранный сервис с обработкой ошибок и паузой на возврат в меню.
     *
     * @param service  экземпляр сервиса задачи
     * @param taskName человекочитаемое имя задачи для сообщений об ошибках
     */
    private static void runTask(Object service, String taskName) {
        try {
            // проверяем тип сервиса и вызываем нужный метод
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
            }

            System.out.println("\n╔══════════════════════════════════════╗");
            System.out.println("║   Нажмите ENTER для возврата в меню  ║");
            System.out.println("╚══════════════════════════════════════╝\n");
            new Scanner(System.in).nextLine(); // пауза, чтобы пользователь увидел вывод
        } catch (Exception e) {
            System.out.println("Ошибка при выполнении " + taskName + ": " + e.getMessage());
            e.printStackTrace();
        }
    }
}