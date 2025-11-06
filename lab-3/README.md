# Сайранов Эльдар ИТ-3 Лабораторная №3

# Задание 1

## Задача 4

### Текст задачи

**Дроби.**<br>
Измените сущность Дробь из задачи **1.5.5**. Реализуйте следующие требования:<br>

- Дробь не может быть изменена после создания
- Необходимо корректно обрабатывать отрицательные значения. Учтите, что знаменатель
  не может быть отрицательным.

Продемонстрируйте работоспособность решения на примерах.

### Алгоритм решения

```java
public class Fraction {
    private final int chislitel;
    private final int znamenatel;

    public Fraction(int chislitel, int znamenatel) {
        if (znamenatel == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен 0");
        }

        int nod = nod(Math.abs(chislitel), Math.abs(znamenatel));

        if (znamenatel < 0) {
            chislitel = -chislitel;
            znamenatel = -znamenatel;
        }
        this.chislitel = chislitel / nod;
        this.znamenatel = znamenatel / nod;
    }

    private int nod(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    @Override
    public String toString() {
        return chislitel + "/" + znamenatel;
    }

    public Fraction sum(Fraction other) {
        int num = this.chislitel * other.znamenatel + other.chislitel * this.znamenatel;
        int den = this.znamenatel * other.znamenatel;

        return new Fraction(num, den);
    }

    public Fraction minus(Fraction other) {
        int num = this.chislitel * other.znamenatel - other.chislitel * this.znamenatel;
        int den = this.znamenatel * other.znamenatel;

        return new Fraction(num, den);
    }

    public Fraction minus(int n) {
        return this.minus(new Fraction(n, 1));
    }

    public Fraction multiply(Fraction other) {
        return new Fraction(this.chislitel * other.chislitel, this.znamenatel * other.znamenatel);
    }

    public Fraction multiply(int n) {
        return new Fraction(this.chislitel * n, this.znamenatel);
    }

    public Fraction div(Fraction other) {
        if (other.chislitel == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно!");
        }

        return new Fraction(this.chislitel * other.znamenatel, this.znamenatel * other.chislitel);
    }

    public Fraction div(int n) {
        if (n == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно!");
        }

        return new Fraction(this.chislitel, this.znamenatel * n);
    }
}
```

## Задача 10

### Текст задачи

**Дороги.**<br>
Измените сущности из задачи **1.3.3**. Гарантируйте, что между двумя городами может быть только одна прямая дорога (другой путь может быть проложен только транзитом через другие города).
Города можно создавать с указанием заранее заданных путей, в любой момент времени можно добавить новую дорогу в любой город и удалить имеющуюся дорогу.

### Алгоритм решения

```java
import java.util.HashMap;
import java.util.Map;

public class City {

    private final String name;
    private final Map<City, Integer> paths;

    public City(String name) {
        this.name = name;
        this.paths = new HashMap<>();
    }

    public City(String name, Map<City, Integer> initialPaths) {
        this.name = name;
        this.paths = new HashMap<>(initialPaths);

        for (Map.Entry<City, Integer> entry : initialPaths.entrySet()) {
            addPath(entry.getKey(), entry.getValue());
        }
    }

    public void addPath(City city, int cost) {
        if (city == null) {
            throw new IllegalArgumentException("Город не может быть null");
        }

        if (city == this) {
            throw new IllegalArgumentException("Нельзя соединить город сам с собой");
        }

        if (cost <= 0) {
            throw new IllegalArgumentException("Стоимость дороги должна быть положительной");
        }

        if (paths.containsKey(city)) {
            System.out.println("Между " + name + " и " + city.name + " уже есть дорога!");
            return;
        }

        paths.put(city, cost);

        // обратная связь
        if (!city.paths.containsKey(this)) {
            city.paths.put(this, cost);
        }
    }

    public void removePath(City city) {
        if (city == null) return;

        paths.remove(city);
        city.paths.remove(this);
    }

    public Map<City, Integer> getPaths() {
        return Map.copyOf(paths);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" -> ");

        for (Map.Entry<City, Integer> entry : paths.entrySet()) {
            sb.append(entry.getKey().name).append(":").append(entry.getValue()).append(" ");
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City other)) return false;
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

```

# Задание 2

## Задача 5

### Текст задачи

**Маршрут.**<br>
Данная задача предполагает разработку новой сущности на основе той, что была получена в задаче **1.4.8** (Город). Сущность Город может быть доработана по своему усмотрению для более удобного использования.<br>
Основная идея задачи в разработке такой сущности, которая будет представлять собой маршрут между двумя городами. Данный маршрут в любой момент времени можно получить как массив для дальнейшего использования. Сущность Маршрут имеет следующие характеристики:

- Имеет Город начала и Город конца пути.
- Инициализация Маршрута может быть выполнена только если указана точка начала и
  конца пути. Если указано nullзначение - то ошибка.
- Точку начала и конца можно изменить в любой момент времени, но они всегда должны
  существовать.
- Может вернуть массив Городов, представляющий собой маршрут из начала в конец.
  Массив содержит все Города (в порядке очереди) через которые надо пройти что бы
  попасть из Города начала в Город конца, причем и начало и конец также содержатся в
  этом массиве. Алгоритм формирования пути в данном случае не существенен, можно
  выбрать вариант со случайным путем, путем проходящим через наименьшее число
  городов, или самым дешевым путем. Если путь найти невозможно – возвращается пустой
  массив.
- Маршрут может быть приведен к строке, которая будет возвращать название всех
  городов маршрута в порядке очередности.
- Создание объекта и изменение точек начала и конца выполняется за константное время
  O(1).

Воспользуйтесь картой городов из задачи **1.3.3** и выведите маршрут из Города F в Город D

### Алгоритм решения

```java

```

# Задание 3

## Задача 1

### Текст задачи

**Запретная Дробь.**<br>
Измените сущность Дробь, полученную в задаче **2.1.4**. Гарантируйте, что невозможно создать такой подвид дроби, который позволял бы создавать Дроби с изменяемым состоянием.

### Алгоритм решения

```java

```

# Задание 4

## Задача 2

### Текст задачи

**Дробь это число.**
Измените сущность Дробь, полученную в задаче **2.3.1**. Дробь должна быть подтипом класса **Number**. Данный класс входит в стандартную редакцию языка **Java**.

### Алгоритм решения

```java

```

# Задание 5

## Задача 1

### Текст задачи

**Сложение.**<br>
Разработайте метод, который принимает набор числовых значений и возвращает их сумму в вещественной форме. С использованием данного метода выполните следующие сложения:

- 2 + 3/5 + 2.3
- 3.6 + 49/12 + 3 + 3/2
- 1/3 + 1

### Алгоритм решения

```java

```

# Задание 6

## Задача 5

### Текст задачи

**Сравнение городов.**<br>
Измените сущность Город, полученную в задаче **2.1.10**. Переопределите метод сравнения объектов по состоянию таким образом, чтобы два Города считались одинаковыми тогда, когда у них одинаковый набор путей в другие города. Также, подвид Города из задачи **2.3.3** должен быть сравним с городом из задачи **2.1.10**.

### Алгоритм решения

```java

```

# Задание 7

## Задача 1

### Текст задачи

**Навести порядок.**<br>
Данная задача предполагает реорганизацию ранее написанных классов. Расположите все ранее написанные классы по пакетам таким образом, чтобы логически близкие классы оказались сгруппированы друг с другом. Имена пакетов должны иметь как минимум трехсоставную форму, вида: **ru.surname.type**. Вместо **surname** следует подставить свою фамилию, а вместо **type** подставить название логического блока. Например, классы описывающие точку, линию, ломаную линию, фигуру, квадрат, треугольник, круг и прямоугольник можно расположить в пакете **ru.surname.geometry**.

### Алгоритм решения

```java

```

## Задача 2

### Текст задачи

**Главный метод.**<br>
Создайте пакет **ru.surname.main** (вместо **surname** необходимо подставить собственную фамилию) в котором расположить класс с точкой входа в исполнение программы (**public static void main**). Также следует проверить, что ни в одном другом пакете нет классов имеющих точку входа в исполнение программы. В этом же пакете необходимо расположить класс (или интерфейс) с методами из задач блока **2.5** и продемонстрировать их работоспособность.

### Алгоритм решения

```java

```

## Задача 3

### Текст задачи

**Возведение в степень.**<br>
Создайте метод принимающий две строки, в которых будут записаны числа **X** и **Y**. Возвращает метод результат возведения **X** в степень **Y**. Для преобразования строки в число следует использовать метод **Integer.parseInt**, а для возведения в степень метод **Math.pow**. Вызовите разработанный метод передав туда параметры командной строки полученные точкой входа в программу. Реализуйте метод так, что бы для возведения в степень и преобразования строки использовались короткие имена статических методов.

### Алгоритм решения

```java

```

# Задание 8

## Задача 4

### Текст задачи

**Клонирование точки.**<br>
Измените сущность Точка из **2.6.2**. Переопределите метод клонирования, унаследованный от класса **Object**, таким образом, чтобы при его вызове возвращался новый объект Точки, значения полей которого будут копиями оригинальной Точки.

### Алгоритм решения

```java

```