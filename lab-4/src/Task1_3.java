public class Task1_3 {

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
                    " (" + person1.name() + " моложе " + person2.name() + ")");
            System.out.println("  person2.compare(person1) = " + person2.compare(person1) +
                    " (" + person2.name() + " старше " + person1.name() + ")");
            System.out.println("  person1.compare(person3) = " + person1.compare(person3) +
                    " (" + person1.name() + " и " + person3.name() + " одного возраста)");

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
                    " ('" + text1.content() + "' короче '" + text2.content() + "')");
            System.out.println("  text2.compare(text1) = " + text2.compare(text1) +
                    " ('" + text2.content() + "' длиннее '" + text1.content() + "')");
            System.out.println("  text1.compare(text3) = " + text1.compare(text3) +
                    " ('" + text1.content() + "' длиннее '" + text3.content() + "')");

            System.out.println("\n✓ Задача 1.3 завершена успешно!");

        } catch (Exception e) {
            System.out.println("✗ Ошибка выполнения: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public record Number(double value) implements Comparable<Number> {

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
        }

    public record Person(String name, int age) implements Comparable<Person> {

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
        }

    public record Text(String content) implements Comparable<Text> {

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
        }

}