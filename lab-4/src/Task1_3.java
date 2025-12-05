public class Task1_3 {

    public static class Number implements Comparable<Number> {
        private final double value;

        public Number(double value) {
            this.value = value;
        }

        @Override
        public int compare(Number other) {
            if (this.value < other.value) {
                return -1;
            } else if (this.value > other.value) {
                return 1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return "Number{" + value + "}";
        }

        public double getValue() {
            return value;
        }
    }

    public static class Person implements Comparable<Person> {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compare(Person other) {
            if (this.age < other.age) {
                return -1;
            } else if (this.age > other.age) {
                return 1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public static class Text implements Comparable<Text> {
        private final String content;

        public Text(String content) {
            this.content = content;
        }

        @Override
        public int compare(Text other) {
            if (this.content.length() < other.content.length()) {
                return -1;
            } else if (this.content.length() > other.content.length()) {
                return 1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return "Text{" +
                    "content='" + content + '\'' +
                    ", length=" + content.length() +
                    '}';
        }

        public String getContent() {
            return content;
        }
    }

    public static void execute() {

        try {
            System.out.println("\n### Демонстрация интерфейса Comparable ###\n");

            System.out.println("▶ ДЕМОНСТРАЦИЯ 1: Сравнение чисел");
            System.out.println("═".repeat(50));

            Number num1 = new Number(10);
            Number num2 = new Number(5);
            Number num3 = new Number(10);

            System.out.println("Числа для сравнения:");
            System.out.println("  num1: " + num1);
            System.out.println("  num2: " + num2);
            System.out.println("  num3: " + num3);

            System.out.println("\nРезультаты сравнения:");
            System.out.println("  num1.compare(num2) = " + num1.compare(num2) +
                    " (num1 > num2, результат > 0)");
            System.out.println("  num2.compare(num1) = " + num2.compare(num1) +
                    " (num2 < num1, результат < 0)");
            System.out.println("  num1.compare(num3) = " + num1.compare(num3) +
                    " (num1 == num3, результат = 0)");

            System.out.println("\n▶ ДЕМОНСТРАЦИЯ 2: Сравнение людей по возрасту");
            System.out.println("═".repeat(50));

            Person person1 = new Person("Иван", 25);
            Person person2 = new Person("Мария", 30);
            Person person3 = new Person("Петр", 25);

            System.out.println("Люди для сравнения:");
            System.out.println("  " + person1);
            System.out.println("  " + person2);
            System.out.println("  " + person3);

            System.out.println("\nРезультаты сравнения по возрасту:");
            System.out.println("  person1.compare(person2) = " + person1.compare(person2) +
                    " (" + person1.getName() + " моложе " + person2.getName() + ")");
            System.out.println("  person2.compare(person1) = " + person2.compare(person1) +
                    " (" + person2.getName() + " старше " + person1.getName() + ")");
            System.out.println("  person1.compare(person3) = " + person1.compare(person3) +
                    " (" + person1.getName() + " и " + person3.getName() + " одного возраста)");

            System.out.println("\n▶ ДЕМОНСТРАЦИЯ 3: Сравнение текстов по длине");
            System.out.println("═".repeat(50));

            Text text1 = new Text("Привет");
            Text text2 = new Text("Добрый день");
            Text text3 = new Text("Java");

            System.out.println("Тексты для сравнения:");
            System.out.println("  " + text1);
            System.out.println("  " + text2);
            System.out.println("  " + text3);

            System.out.println("\nРезультаты сравнения по длине:");
            System.out.println("  text1.compare(text2) = " + text1.compare(text2) +
                    " ('" + text1.getContent() + "' короче '" + text2.getContent() + "')");
            System.out.println("  text2.compare(text1) = " + text2.compare(text1) +
                    " ('" + text2.getContent() + "' длиннее '" + text1.getContent() + "')");
            System.out.println("  text1.compare(text3) = " + text1.compare(text3) +
                    " ('" + text1.getContent() + "' длиннее '" + text3.getContent() + "')");

            System.out.println("\n" + "═".repeat(50));
            System.out.println("▶ ИНТЕРАКТИВНАЯ ЧАСТЬ");
            System.out.println("═".repeat(50));

            System.out.println("\nВыберите тип данных для сравнения:");
            System.out.println("  1 - Числа");
            System.out.println("  2 - Люди (по возрасту)");
            System.out.println("  3 - Тексты (по длине)");
            System.out.print("\nВаш выбор: ");

            int choice = Main.getIntInput("");

            switch (choice) {
                case 1:
                    interactiveNumberComparison();
                    break;
                case 2:
                    interactivePersonComparison();
                    break;
                case 3:
                    interactiveTextComparison();
                    break;
                default:
                    System.out.println("✗ Неправильный выбор");
            }

            System.out.println("\n✓ Задача 1.3 завершена успешно!");

        } catch (Exception e) {
            System.out.println("✗ Ошибка выполнения: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void interactiveNumberComparison() {
        System.out.println("\n### Интерактивное сравнение чисел ###\n");

        System.out.print("Введите первое число: ");
        double val1 = Main.getDoubleInput("");

        System.out.print("Введите второе число: ");
        double val2 = Main.getDoubleInput("");

        Number n1 = new Number(val1);
        Number n2 = new Number(val2);

        System.out.println("\nЧисла: " + n1 + " и " + n2);
        int result = n1.compare(n2);
        System.out.println("Результат сравнения: " + result);

        if (result < 0) {
            System.out.println("Вывод: " + val1 + " < " + val2);
        } else if (result > 0) {
            System.out.println("Вывод: " + val1 + " > " + val2);
        } else {
            System.out.println("Вывод: " + val1 + " == " + val2);
        }
    }

    private static void interactivePersonComparison() {
        System.out.println("\n### Интерактивное сравнение людей ###\n");

        System.out.print("Введите имя первого человека: ");
        String name1 = Main.getStringInput("");

        System.out.print("Введите возраст первого человека: ");
        int age1 = Main.getIntInput("");

        System.out.print("Введите имя второго человека: ");
        String name2 = Main.getStringInput("");

        System.out.print("Введите возраст второго человека: ");
        int age2 = Main.getIntInput("");

        Person p1 = new Person(name1, age1);
        Person p2 = new Person(name2, age2);

        System.out.println("\nЛюди: " + p1 + " и " + p2);
        int result = p1.compare(p2);
        System.out.println("Результат сравнения по возрасту: " + result);

        if (result < 0) {
            System.out.println("Вывод: " + name1 + " моложе " + name2);
        } else if (result > 0) {
            System.out.println("Вывод: " + name1 + " старше " + name2);
        } else {
            System.out.println("Вывод: " + name1 + " и " + name2 + " одного возраста");
        }
    }

    private static void interactiveTextComparison() {
        System.out.println("\n### Интерактивное сравнение текстов ###\n");

        System.out.print("Введите первый текст: ");
        String text1 = Main.getStringInput("");

        System.out.print("Введите второй текст: ");
        String text2 = Main.getStringInput("");

        Text t1 = new Text(text1);
        Text t2 = new Text(text2);

        System.out.println("\nТексты: " + t1 + " и " + t2);
        int result = t1.compare(t2);
        System.out.println("Результат сравнения по длине: " + result);

        if (result < 0) {
            System.out.println("Вывод: '" + text1 + "' короче '" + text2 + "'");
        } else if (result > 0) {
            System.out.println("Вывод: '" + text1 + "' длиннее '" + text2 + "'");
        } else {
            System.out.println("Вывод: '" + text1 + "' и '" + text2 + "' одинаковой длины");
        }
    }

}