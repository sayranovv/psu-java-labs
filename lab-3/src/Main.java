import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int exercise = 0;
        int task = 0;

        while (true) {
            System.out.println("Введите номер задания:");
            if (sc.hasNextInt()) {
                exercise = sc.nextInt();
                break;
            } else {
                System.out.println("Ошибка! Пожалуйста, введите целое число");
                sc.next();
            }
        }

        while (true) {
            System.out.println("Введите номер задачи:");
            if (sc.hasNextInt()) {
                task = sc.nextInt();
                break;
            } else {
                System.out.println("Ошибка! Пожалуйста, введите целое число");
                sc.next();
            }
        }

        boolean valid = true;

        if (exercise == 1 && task == 4) {
            System.out.println("------------ Задача 1 | Задание 4 ------------");

            Fraction f1 = new Fraction(1, 2);
            Fraction f2 = new Fraction(3, 4);
            Fraction f3 = new Fraction(-2, 5);
            Fraction f4 = new Fraction(2, -5);

            System.out.println("f1 = " + f1);
            System.out.println("f2 = " + f2);
            System.out.println("f3 = " + f3);
            System.out.println("f4 = " + f4);

            System.out.println("\nОперации:");
            System.out.println("f1 + f2 = " + f1.sum(f2));
            System.out.println("f1 - f2 = " + f1.minus(f2));
            System.out.println("f1 * f2 = " + f1.multiply(f2));
            System.out.println("f1 / f2 = " + f1.div(f2));

            System.out.println("\nОперации с целыми:");
            System.out.println("f1 - 1 = " + f1.minus(1));
            System.out.println("f2 * 2 = " + f2.multiply(2));
            System.out.println("f3 / 2 = " + f3.div(2));
        } else if (exercise == 1 && task == 10) {
            System.out.println("------------ Задача 1 | Задание 10 ------------");

            City perm = new City("Пермь");
            City moscow = new City("Москва");
            City kazan = new City("Казань");

            perm.addPath(moscow, 1400);
            perm.addPath(kazan, 600);
            moscow.addPath(kazan, 800);

            moscow.addPath(perm, 1400);

            System.out.println("Сети дорог:");
            System.out.println(perm);
            System.out.println(moscow);
            System.out.println(kazan);

            System.out.println("\nУдаляем дорогу Пермь-Казань...");
            perm.removePath(kazan);

            System.out.println(perm);
            System.out.println(kazan);

        } else {
            valid = false;
        }

        if (!valid) {
            System.out.println("Нет такой задачи!");
        }
    }
}
