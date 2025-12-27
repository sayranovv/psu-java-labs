# Сайранов Эльдар ИТ-3 Лабораторная №5

# Задание 1. Шаблоны

### Текст задачи

В класс Дробь, добавить интерфейс на два метода: получение вещественного значения, установка числителя и установка
знаменателя. Сгенерировать такую версию дроби, которая будет кэшировать вычисление вещественного значения.
Если раннее в вашем варианте не было Дроби, то создайте сущность Дробь со следующими особенностями:

- Имеет числитель: целое число
- Имеет знаменатель: целое число
- Дробь может быть создана с указанием числителя и знаменателя
- Может вернуть строковое представление вида “числитель/знаменатель”
- Необходимо корректно обрабатывать отрицательные значения. Учтите, что знаменатель не может быть отрицательным.
- Переопределите метод сравнения объектов по состоянию таким образом, чтобы две дроби считались одинаковыми тогда, когда
  у них одинаковые значения числителя и знаменателя

### Алгоритм решения

**FractionCached.java:**

```java
package entities;

public class FractionCached extends Fraction {
    private Double cachedValue;

    private boolean isCacheValid;

    public FractionCached() {
        super();
        initializeCache();
    }

    public FractionCached(int numerator, int denominator) {
        super(numerator, denominator);
        initializeCache();
    }

    private void initializeCache() {
        this.cachedValue = null;
        this.isCacheValid = false;
    }

    @Override
    public void setNumerator(int numerator) {
        super.setNumerator(numerator);
        isCacheValid = false;
    }

    @Override
    public void setDenominator(int denominator) {
        super.setDenominator(denominator);
        isCacheValid = false;
    }

    @Override
    public double getDecimalValue() {
        if (!isCacheValid) {
            cachedValue = super.getDecimalValue();
            isCacheValid = true;
        }

        return cachedValue;
    }

    public Double getCachedValueDirect() {
        return cachedValue;
    }
}
```

**Task1Service.java:**

```java
package services;

import entities.*;

public class Task1Service {
    public void runTask1() {
        System.out.println("\n\n─── КЭШИРОВАННАЯ ДРОБЬ ───\n");

        FractionCached cachedFraction = new FractionCached(7, 5);
        System.out.println("Создана кэшированная дробь: " + cachedFraction);

        System.out.println("\nПервое обращение к getDecimalValue():");
        double value1 = cachedFraction.getDecimalValue();
        System.out.println("  Вычислено и кэшировано: " + value1);

        System.out.println("\nВторое обращение к getDecimalValue():");
        double value2 = cachedFraction.getDecimalValue();
        System.out.println("  Возвращено из кэша: " + value2);
        System.out.println("  (Вычисление не произведено, использован кэш)");

        System.out.println("\nИзменение числителя с 7 на 14...");
        cachedFraction.setNumerator(14);
        System.out.println("Кэш инвалидирован");

        System.out.println("\nОбращение к getDecimalValue() после изменения:");
        double value3 = cachedFraction.getDecimalValue();
        System.out.println("  Пересчитано и кэшировано: " + value3);
        System.out.println("  Новая дробь: " + cachedFraction);

    }
}
```

# Задание 2. Структурные шаблоны

### Текст задачи

**Количество мяуканий.**

Необходимо воспользоваться классом Кот и методом принимающим всех мяукающих из задачи 2.5.4. Необходимо таким образом
передать кота в указанный метод, что бы после окончания его работы узнать сколько раз мяукал кот за время его работы. На
рисунке показан пример работы. Перед вызовом метода создаем кота, отправляем ссылку на кота в метод, после окончания его
работы выводим количество мяуканий на экран. Кота изменять нельзя.

```java
Meowable m = ... // создаем кота
        Funs.

meowsCare(m);
System.out.

println(...) // вывод: кот мяукает 5 раз
```

Если раннее в вашем варианте не было Кота, то создайте

1. Сущность Кот, которая описывается следующим образом:

- Имеет Имя (строка)
- Для создания необходимо указать имя кота.
- Может быть приведен к текстовой форме вида: “кот: Имя”
- Может помяукать, что приводит к выводу на экран следующего текста: “Имя: мяу!”, вызвать мяуканье можно без параметров.

2. Интерфейс Мяуканье: разработайте метод, который принимает набор объектов способных мяукать и вызывает мяуканье у
   каждого объекта. Мяукающие объекты должны иметь метод со следующей сигнатурой:

`
public void meow();
`

### Алгоритм решения

**Cat.java**

```java
package entities;

public class Cat implements Meowable {
    private String name;

    private int meowCount;

    public Cat(String name) {
        if (!name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Имя кота не может быть пусто");
        }
        this.meowCount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public int getMeowCount() {
        return meowCount;
    }

    public void resetMeowCount() {
        this.meowCount = 0;
    }

    @Override
    public void meow() {
        System.out.println(name + ": мяу!");
        meowCount++;
    }

    @Override
    public String toString() {
        return "кот: " + name;
    }
}
```

**Meowable.java:**

```java
package entities;

public interface Meowable {
    void meow();
}
```

**Task2Service.java:**

```java
package services;

import entities.*;

import java.util.*;

public class Task2Service {

    public void runTask2() {

        System.out.println("─── СОЗДАНИЕ КОТА ───\n");
        Cat myCat = new Cat("Пушок");
        System.out.println("Создан кот: " + myCat);
        System.out.println("Начальный счетчик мяуканий: " + myCat.getMeowCount());

        System.out.println("\n─── ПРЯМОЕ МЯУКАНЬЕ КОТА ───\n");
        myCat.meow();
        myCat.meow();
        myCat.meow();
        System.out.println("Счетчик мяуканий после 3 мяуканий: " + myCat.getMeowCount());

        myCat.resetMeowCount();
        System.out.println("\nСчетчик сброшен: " + myCat.getMeowCount());

        System.out.println("\n\n─── СТРУКТУРНЫЙ ПАТТЕРН: РАБОТА ЧЕРЕЗ ИНТЕРФЕЙС ───\n");
        System.out.println("Передаем кота (через интерфейс Meowable) в метод makeThemMeow()");
        System.out.println("Метод вызывает meow() у всех переданных объектов:\n");

        Meowable[] meowables = {myCat};

        makeThemMeow(meowables);

        System.out.println("\n--- РЕЗУЛЬТАТ ---");
        System.out.println("Кот мяукает " + myCat.getMeowCount() + " раз");

        System.out.println("\n\n─── ДЕМОНСТРАЦИЯ С НЕСКОЛЬКИМИ КОТАМИ ───\n");

        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Барсик");
        Cat cat3 = new Cat("Тигра");

        System.out.println("Созданы коты: " + cat1.getName() + ", " + cat2.getName() + ", " + cat3.getName());
        System.out.println("\nПередаем всех котов в метод makeThemMeow():\n");

        Meowable[] allCats = {cat1, cat2, cat3};
        makeThemMeow(allCats);

        System.out.println("\n--- РЕЗУЛЬТАТЫ ---");
        System.out.println(cat1.getName() + " мяукает " + cat1.getMeowCount() + " раз");
        System.out.println(cat2.getName() + " мяукает " + cat2.getMeowCount() + " раз");
        System.out.println(cat3.getName() + " мяукает " + cat3.getMeowCount() + " раз");
    }

    private void makeThemMeow(Meowable[] meowables) {
        for (Meowable meowable : meowables) {
            meowable.meow();
        }
    }
}
```

# Задание 3. Список

## Задача 5

### Текст задачи

Составить программу, которая удаляет из списка L все элементы с указанным значением.

### Алгоритм решения

**Task3Service.java:**

```java
package services;

import java.util.*;

public class Task3Service {

    public void runTask3() {
        List<Integer> list = new ArrayList<>();
        System.out.println("─── СОЗДАНИЕ И ЗАПОЛНЕНИЕ СПИСКА ───\n");

        int[] initialValues = {1, 2, 5, 3, 5, 4, 5, 6, 5, 7};
        for (int value : initialValues) {
            list.add(value);
        }

        System.out.println("Исходный список: " + list);
        System.out.println("Элементов в списке: " + list.size());

        int valueToRemove = 5;
        int countToRemove = 0;
        for (int value : list) {
            if (value == valueToRemove) {
                countToRemove++;
            }
        }

        System.out.println("\n─── УДАЛЕНИЕ ЭЛЕМЕНТОВ ───\n");
        System.out.println("Требуется удалить все элементы со значением: " + valueToRemove);
        System.out.println("Найдено элементов для удаления: " + countToRemove);

        System.out.println("\nУдаляем элементы...");
        removeAllOccurrences(list, valueToRemove);

        System.out.println("\n─── РЕЗУЛЬТАТ ───\n");
        System.out.println("Список после удаления: " + list);
        System.out.println("Осталось элементов: " + list.size());
    }

    private <T> void removeAllOccurrences(List<T> list, T value) {
        Iterator<T> iterator = list.iterator();

        while (iterator.hasNext()) {
            T element = iterator.next();

            if ((element == null && value == null) || (element != null && element.equals(value))) {
                iterator.remove();
            }
        }
    }
}
```

# Задание 4. Мап

## Задача 2

### Текст задачи

На городской олимпиаде по информатике участникам было предложено выполнить 3 задания, каждое из которых оценивалось по
25-балльной шкале. Известно, что общее количество участников первого тура олимпиады не превосходит 250 человек. На вход
программы подаются сведения о результатах олимпиады. В первой строке вводится количество участников N. Далее следуют N
строк, имеющих следующий формат:

**<Фамилия><Имя><Баллы>**

Здесь <Фамилия> – строка, состоящая не более чем из 20 символов;<Имя>– строка, состоящая не более чем из 15 символов; <
Баллы> – строка, содержащая три целых числа, разделенных пробелом, соответствующих баллам, полученным участником за
каждое задание первого тура. При этом <Фамилия> и <Имя>, <Имя> и <Баллы> разделены одним пробелом. Примеры входных
строк:

**Петрова Ольга 25 18 16**<br>
**Калиниченко Иван 14 19 15**

Напишите программу, которая будет выводить на экран фамилию и имя участника, набравшего максимальное количество баллов.
Если среди остальных участников есть ученики, набравшие такое же количество баллов, то их фамилии и имена также следует
вывести. При этом имена и фамилии можно выводить в произвольном порядке

### Алгоритм решения

**Task4Service.java**

```java
package services;

import utils.FileManager;

import java.io.*;
import java.util.*;

public class Task4Service {

    public void runTask4() {

        String filePath = "data/olympiad_data.txt";

        try {
            List<String> lines = FileManager.readFileLines(filePath);

            System.out.println("Файл: " + filePath);
            System.out.println("Прочитано строк: " + lines.size());

            int participantCount = Integer.parseInt(lines.get(0));
            System.out.println("Количество участников: " + participantCount);

            Map<String, Integer> results = new LinkedHashMap<>();

            for (int i = 1; i <= participantCount; i++) {
                String line = lines.get(i);

                String[] parts = line.trim().split("\\s+");

                String lastName = parts[0];
                String firstName = parts[1];
                int score1 = Integer.parseInt(parts[2]);
                int score2 = Integer.parseInt(parts[3]);
                int score3 = Integer.parseInt(parts[4]);

                int totalScore = score1 + score2 + score3;

                String fullName = lastName + " " + firstName;
                results.put(fullName, totalScore);

                System.out.println("Обработан: " + fullName);
                System.out.println("  Баллы за задания: " + score1 + ", " + score2 + ", " + score3);
                System.out.println("  Общее количество баллов: " + totalScore + "\n");
            }

            int maxScore = Collections.max(results.values());
            System.out.println("Максимальное количество баллов: " + maxScore);

            List<String> winners = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : results.entrySet()) {
                if (entry.getValue() == maxScore) {
                    winners.add(entry.getKey());
                }
            }

            System.out.println("Участники набравшие максимальный результат (" + maxScore + " баллов):");
            for (String winner : winners) {
                System.out.println("  ► " + winner);
            }

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка при парсинге данных: " + e.getMessage());
        }
    }
}
```

# Задание 5. Сет

## Задача 3

### Текст задачи

Файл содержит текст на русском языке. Напечатать в алфавитном порядке все согласные буквы, которые входят ровно в одно
слово.

### Алгоритм решения

**Task5Service.java:**

```java
package services;

import utils.FileManager;

import java.io.*;
import java.util.*;

public class Task5Service {

    public void runTask5() {
        String filePath = "data/russian_text.txt";

        try {
            String text = FileManager.readFileAsString(filePath);

            System.out.println(text);

            String lowerText = text.toLowerCase();

            String consonants = "бвгджзйклмнпрстфхцчшщ";

            Map<Character, Set<String>> consonantWords = new TreeMap<>();

            String[] words = lowerText.split("[^а-яЁё]+");

            System.out.println("Найдено слов: " + words.length);
            System.out.println("Слова: " + Arrays.toString(words) + "\n");

            for (String word : words) {
                if (word.isEmpty()) continue;

                for (char ch : word.toCharArray()) {
                    if (consonants.indexOf(ch) >= 0) {
                        if (!consonantWords.containsKey(ch)) {
                            consonantWords.put(ch, new HashSet<>());
                        }

                        consonantWords.get(ch).add(word);
                    }
                }
            }

            List<Character> resultConsonants = new ArrayList<>();

            for (Character consonant : consonantWords.keySet()) {
                Set<String> words_with_consonant = consonantWords.get(consonant);

                if (words_with_consonant.size() == 1) {
                    resultConsonants.add(consonant);
                }
            }

            if (resultConsonants.isEmpty()) {
                System.out.println("Не найдено согласных букв входящих ровно в одно слово");
            } else {
                Collections.sort(resultConsonants);

                System.out.println("Найденные согласные (в алфавитном порядке):");
                for (Character consonant : resultConsonants) {
                    Set<String> wordsSet = consonantWords.get(consonant);
                    String word = wordsSet.iterator().next();
                    System.out.println("  '" + consonant + "' - входит в слово: \"" + word + "\"");
                }
            }

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
```

# Задание 6. Очередь

## Задача 4

### Текст задачи

Проверить равенство участка очереди с i-го по j-й элемент (i < j).

### Алгоритм решения

**Task6Service.java:**

```java
package services;

import java.util.*;

public class Task6Service {

    public void runTask6() {
        Queue<Integer> queue = new LinkedList<>();

        int[] values = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        for (int value : values) {
            queue.add(value);
        }

        System.out.println("Очередь: " + queue);
        System.out.println("Размер очереди: " + queue.size());

        System.out.println("\n\n─── УЧАСТОК С I=2, J=5 ───\n");

        int i1 = 2;
        int j1 = 5;
        System.out.println("Проверяем участок с индекса " + i1 + " по индекс " + j1);

        List<Integer> queueList1 = new ArrayList<>(queue);

        System.out.println("\nЭлементы в очереди:");
        for (int idx = 0; idx < queueList1.size(); idx++) {
            String marker = (idx >= i1 && idx <= j1) ? " ← УЧАСТОК" : "";
            System.out.println("  [" + idx + "] = " + queueList1.get(idx) + marker);
        }

        List<Integer> segment1 = queueList1.subList(i1, j1 + 1);
        System.out.println("\nИзвлеченный участок: " + segment1);
        System.out.println("Элементы участка: " + String.join(", ", segment1.stream().map(String::valueOf).toArray(String[]::new)));

        System.out.println("\n\n─── УЧАСТОК С I=4, J=7 ───\n");

        int i2 = 4;
        int j2 = 7;
        System.out.println("Проверяем участок с индекса " + i2 + " по индекс " + j2);

        List<Integer> queueList2 = new ArrayList<>(queue);

        System.out.println("\nЭлементы в очереди:");
        for (int idx = 0; idx < queueList2.size(); idx++) {
            String marker = (idx >= i2 && idx <= j2) ? " ← УЧАСТОК" : "";
            System.out.println("  [" + idx + "] = " + queueList2.get(idx) + marker);
        }

        List<Integer> segment2 = queueList2.subList(i2, j2 + 1);
        System.out.println("\nИзвлеченный участок: " + segment2);
        System.out.println("Элементы участка: " + String.join(", ", segment2.stream().map(String::valueOf).toArray(String[]::new)));

        System.out.println("\n\n─── ПРОВЕРКА РАВЕНСТВА ───\n");

        System.out.println("Участок 1: " + segment1);
        System.out.println("Участок 2: " + segment2);

        boolean areEqual = segment1.equals(segment2);
        System.out.println("\nУчастки равны: " + areEqual);
    }
}
```

# Задание 7. Стрим

## Задача 1

### Текст задачи

Необходимо написать стрим:

Дан набор объектов типа Point, необходимо взять все Point в разных координатах, убрать с одинаковыми X,Y, отсортировать
по X, отрицательные Y сделать положительными и собрать это все в ломаную (объект типа Polyline)

Если раннее в вашем варианте не было задание с классом Point и Polyline, то написать их:

1. Класс Point:

- Координата Х: число.
- Координата Y: число.
- Может возвращать текстовое представление вида “{X;Y}”.

2. Класс Line (Линия), расположенная на двумерной плоскости, которая описывается:

- Координата начала: Точка
- Координата конца: Точка
- Может возвращать текстовое представление вида “Линия от {X1;Y1} до {X2;Y2}”

3. Класс Polyline (Ломаная), которая будет представлять собой ломаную линию. Ломаная линия представляет собой набор
   следующих характеристик:

- Имеет массив Точек, через которые линия проходит.
- Может быть приведена к строковой форме вида “Линия [Т1,T2,…,TN]”, где TN – это результат приведения к строке Точки с
  номером N

### Алгоритм решения

**Task7Service.java:**

```java
private void runTask7Part1() {
    System.out.println("─── ЗАДАНИЕ 7.1: POLYLINE ИЗ STREAM ───\n");

    List<Point> points = Arrays.asList(
            new Point(1, 5),
            new Point(3, -2),
            new Point(1, 5),
            new Point(4, 3),
            new Point(2, -1),
            new Point(3, -2),
            new Point(5, 4),
            new Point(2, -1)
    );

    System.out.println("Исходный список точек:");
    for (int i = 0; i < points.size(); i++) {
        System.out.println("  [" + i + "] " + points.get(i));
    }

    System.out.println("\n--- Применяем Stream операции ---\n");
    System.out.println("1. Удаляем дубликаты (distinct)");
    System.out.println("2. Сортируем по координате X (sorted)");
    System.out.println("3. Делаем Y положительным (map с abs)");
    System.out.println("4. Собираем в Polyline (collect)\n");

    List<Point> processedPoints = points.stream()
            .distinct()
            .sorted(Comparator.comparingDouble(Point::getX))
            .map(point -> {
                if (point.getY() < 0) {
                    point.setY(-point.getY());
                }
                return point;
            })
            .collect(Collectors.toList());

    System.out.println("Результат после Stream операций:");
    for (int i = 0; i < processedPoints.size(); i++) {
        System.out.println("  [" + i + "] " + processedPoints.get(i));
    }

    Polyline polyline = new Polyline(processedPoints);
    System.out.println("\n--- Создана Polyline ---\n");
    System.out.println("Результат: " + polyline);
    System.out.println("Количество точек: " + polyline.getPointCount());
}
```

## Задача 2

### Текст задачи

Дан текстовый файл со строками, содержащими имя человека и его номер в следующей форме:

Вася:5<br>
Петя:3<br>
Аня:5

Номера людей могут повторяться. У каких-то людей может не быть номера. Необходимо написать стрим выполняющую следующее:
читаются все люди из файла, все имена приводится к нижнему регистру, но с первой буквой в верхнем регистре, убираем из
перечня всех людей без номеров, а имена оставшихся группируются по их номеру:

[5:[Вася, Аня], 3:[Петя]]

### Алгоритм решения

**Task7Service.java:**

```java
private void runTask7Part2() {
    System.out.println("\n\n─── ЗАДАНИЕ 7.2: ГРУППИРОВКА ЛЮДЕЙ ПО НОМЕРАМ ───\n");

    String filePath = "data/people_data.txt";

    try {
        List<String> lines = FileManager.readFileLines(filePath);

        System.out.println("Исходные данные из файла:");
        for (String line : lines) {
            System.out.println("  " + line);
        }

        System.out.println("\n--- Применяем Stream операции ---\n");
        System.out.println("1. Парсим каждую строку в объект Person");
        System.out.println("2. Приводим имена в формат: первая буква заглавная, остальные маленькие");
        System.out.println("3. Фильтруем людей без номеров (номер != null)");
        System.out.println("4. Группируем по номеру\n");

        Map<Integer, List<String>> groupedByNumber = lines.stream()
                .filter(line -> !line.trim().isEmpty())
                .map(line -> {
                    String[] parts = line.split(":");
                    String name = parts[0].trim();

                    String formattedName = name.substring(0, 1).toUpperCase() +
                            name.substring(1).toLowerCase();

                    if (parts.length > 1 && !parts[1].trim().isEmpty()) {
                        return new AbstractMap.SimpleEntry<>(formattedName, Integer.parseInt(parts[1].trim()));
                    } else {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        AbstractMap.SimpleEntry::getValue,
                        Collectors.mapping(
                                AbstractMap.SimpleEntry::getKey,
                                Collectors.toList()
                        )
                ));

        System.out.println("─── РЕЗУЛЬТАТЫ ГРУППИРОВКИ ───\n");

        groupedByNumber.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    Integer number = entry.getKey();
                    List<String> names = entry.getValue();
                    System.out.println(number + ": " + names);
                });

    } catch (IOException e) {
        System.out.println("Ошибка при чтении файла: " + e.getMessage());
    }
}
```


