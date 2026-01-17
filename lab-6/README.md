# Сайранов Эльдар ИТ-3 Лабораторная №6

# Задание 1. Аннотации

## Задача 1

### Текст задачи

**@Invoke.**

Разработайте аннотацию **@Invoke**, со следующими характеристиками:

- Целью может быть только МЕТОД
- Доступна во время исполнения программы
- Не имеет свойств

Создайте класс, содержащий несколько методов, и проаннотируйте хотя бы один из них аннотацией **@Invoke**.
Реализуйте обработчик (через Reflection API), который находит методы, отмеченные аннотацией **@Invoke**, и вызывает их автоматически.

### Алгоритм решения

**Invoke.java**

```java
package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Invoke {
}
```

**InvokeDemo.java**

```java
package entities;

import annotations.Invoke;

public class InvokeDemo {

    private boolean invoked;

    @Invoke
    public String sayHello() {
        invoked = true;
        return "Hello from @Invoke method";
    }

    public String skipMe() {
        return "Not annotated";
    }

    public boolean wasInvoked() {
        return invoked;
    }
}
```

**Task1Service.java**

```java
package services;

import annotations.Invoke;
import entities.InvokeDemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Task1Service {

    public void runTask1() {
        System.out.println("\n─── ЗАДАНИЕ 1: @Invoke ───\n");
        InvokeDemo demo = new InvokeDemo();
        List<Object> results = invokeAnnotatedMethods(demo);

        System.out.println("Вызваны методы с @Invoke. Количество результатов: " + results.size());
        for (Object result : results) {
            System.out.println("  -> результат: " + result);
        }
        System.out.println("Флаг вызова внутри объекта: " + demo.wasInvoked());
    }

    public List<Object> invokeAnnotatedMethods(Object target) {
        List<Object> results = new ArrayList<>();
        if (target == null) {
            return results;
        }

        Class<?> clazz = target.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Invoke.class)) {
                try {
                    method.setAccessible(true);
                    Object result = method.invoke(target);
                    results.add(result);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new IllegalStateException("Не удалось вызвать метод " + method.getName(), e);
                }
            }
        }
        return results;
    }
}
```

## Задача 2

### Текст задачи

**@Default.**

Разработайте аннотацию **@Default**, со следующими характеристиками:

- Целью может быть ТИП или ПОЛЕ
- Доступна во время исполнения программы
- Имеет обязательное свойство **value** типа **Class**

Проаннотируйте какой-либо класс данной аннотацией, указав тип по умолчанию.
Напишите обработчик, который выводит имя указанного класса по умолчанию.

### Алгоритм решения

**Default.java**

```java
package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Default {
    Class<?> value();
}
```

**DefaultDemo.java**

```java
package entities;

import annotations.Default;

@Default(String.class)
public class DefaultDemo {
    private String value = "demo";

    public String getValue() {
        return value;
    }
}
```

**Task2Service.java**

```java
package services;

import annotations.Default;
import entities.DefaultDemo;

public class Task2Service {

    public void runTask2() {
        System.out.println("\n─── ЗАДАНИЕ 2: @Default ───\n");
        Default annotation = DefaultDemo.class.getAnnotation(Default.class);
        if (annotation != null) {
            System.out.println("Аннотация @Default обнаружена.");
            System.out.println("Класс по умолчанию: " + annotation.value().getName());
        } else {
            System.out.println("Аннотация @Default отсутствует на классе DefaultDemo.");
        }
    }
}
```

## Задача 3

### Текст задачи

**@ToString.**

Разработайте аннотацию **@ToString**, со следующими характеристиками:

- Целью может быть ТИП или ПОЛЕ
- Доступна во время исполнения программы
- Имеет необязательное свойство **value** c двумя вариантами значений: **YES** или **NO**
- Значение свойства по умолчанию: **YES**

Проаннотируйте класс аннотацией **@ToString**, а одно из полей – с **@ToString(Mode.NO)**.
Создайте метод, который формирует строковое представление объекта, учитывая только те поля, где **@ToString** имеет значение **YES**.

### Алгоритм решения

**ToString.java**

```java
package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ToString {
    Mode value() default Mode.YES;
    enum Mode { YES, NO }
}
```

**ToStringDemo.java**

```java
package entities;

import annotations.ToString;

@ToString
public class ToStringDemo {

    @ToString
    private String title = "Included";

    @ToString(ToString.Mode.NO)
    private String secret = "Hidden";

    private int number = 42;

    public String getTitle() {
        return title;
    }

    public String getSecret() {
        return secret;
    }

    public int getNumber() {
        return number;
    }
}
```

**Task3Service.java**

```java
package services;

import annotations.ToString;
import entities.ToStringDemo;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

public class Task3Service {

    public void runTask3() {
        System.out.println("\n─── ЗАДАНИЕ 3: @ToString ───\n");
        ToStringDemo demo = new ToStringDemo();
        String representation = buildString(demo);
        System.out.println("Строковое представление объекта:");
        System.out.println(representation);
    }

    public String buildString(Object obj) {
        if (obj == null) {
            return "null";
        }

        Class<?> clazz = obj.getClass();
        if (!clazz.isAnnotationPresent(ToString.class)) {
            return obj.toString();
        }

        Map<String, Object> included = new LinkedHashMap<>();
        for (Field field : clazz.getDeclaredFields()) {
            ToString fieldAnno = field.getAnnotation(ToString.class);
            ToString.Mode mode = fieldAnno != null ? fieldAnno.value() : ToString.Mode.YES;
            if (mode == ToString.Mode.NO) {
                continue;
            }
            try {
                field.setAccessible(true);
                included.put(field.getName(), field.get(obj));
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Не удалось прочитать поле " + field.getName(), e);
            }
        }

        StringBuilder sb = new StringBuilder(clazz.getSimpleName()).append("{");
        boolean first = true;
        for (Map.Entry<String, Object> entry : included.entrySet()) {
            if (!first) {
                sb.append(", ");
            }
            sb.append(entry.getKey()).append("=").append(entry.getValue());
            first = false;
        }
        sb.append("}");
        return sb.toString();
    }
}
```

## Задача 4

### Текст задачи

**@Validate.**

Разработайте аннотацию **@Validate**, со следующими характеристиками:

- Целью может быть ТИП или АННОТАЦИЯ
- Доступна во время исполнения программы
- Имеет обязательное свойство **value**, типа **Class[]**

Проаннотируйте класс аннотацией **@Validate**, передав список типов для проверки.
Реализуйте обработчик, который выводит, какие классы указаны в аннотации.

### Алгоритм решения

**Validate.java**

```java
package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {
    Class<?>[] value();
}
```

**ValidateDemo.java**

```java
package entities;

import annotations.Validate;

@Validate({String.class, Integer.class})
public class ValidateDemo {
}
```

**Task4Service.java**

```java
package services;

import annotations.Validate;
import entities.ValidateDemo;

public class Task4Service {

    public void runTask4() {
        System.out.println("\n─── ЗАДАНИЕ 4: @Validate ───\n");
        Validate annotation = ValidateDemo.class.getAnnotation(Validate.class);
        if (annotation == null) {
            System.out.println("Аннотация @Validate не найдена на классе ValidateDemo.");
            return;
        }
        System.out.println("Найденные классы для валидации:");
        for (Class<?> validator : annotation.value()) {
            System.out.println(" - " + validator.getName());
        }
    }
}
```

## Задача 5

### Текст задачи

**@Two.**

Разработайте аннотацию **@Two**, со следующими характеристиками:

- Целью может быть ТИП
- Доступна во время исполнения программы
- Имеет два обязательных свойства: **first** типа **String** и **second** типа **int**

Проаннотируйте какой-либо класс аннотацией **@Two**, передав строковое и числовое значения.
Реализуйте обработчик, который считывает и выводит значения этих свойств.

### Алгоритм решения

**Two.java**

```java
package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Two {
    String first();
    int second();
}
```

**TwoDemo.java**

```java
package entities;

import annotations.Two;

@Two(first = "sample", second = 7)
public class TwoDemo {
}
```

**Task5Service.java**

```java
package services;

import annotations.Two;
import entities.TwoDemo;

public class Task5Service {

    public void runTask5() {
        System.out.println("\n─── ЗАДАНИЕ 5: @Two ───\n");
        Two annotation = TwoDemo.class.getAnnotation(Two.class);
        if (annotation == null) {
            System.out.println("Аннотация @Two отсутствует на классе TwoDemo.");
            return;
        }
        System.out.println("Свойство first: " + annotation.first());
        System.out.println("Свойство second: " + annotation.second());
    }
}
```

## Задача 6

### Текст задачи

**@Cache.**

Разработайте аннотацию **@Cache**, со следующими характеристиками:

- Целью может быть ТИП
- Доступна во время исполнения программы
- Имеет необязательное свойство **value**, типа **String[]**
- Значение свойства по умолчанию: пустой массив

Проаннотируйте класс аннотацией **@Cache**, указав несколько кешируемых областей.
Создайте обработчик, который выводит список всех кешируемых областей или сообщение, что
список пуст.

### Алгоритм решения

**Cache.java**

```java
package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    String[] value() default {};
}
```

**CacheDemo.java**

```java
package entities;

import annotations.Cache;

@Cache({"users", "orders", "products"})
public class CacheDemo {
}
```

**Task6Service.java**

```java
package services;

import annotations.Cache;
import entities.CacheDemo;

import java.util.Arrays;

public class Task6Service {

    public void runTask6() {
        System.out.println("\n─── ЗАДАНИЕ 6: @Cache ───\n");
        Cache annotation = CacheDemo.class.getAnnotation(Cache.class);
        if (annotation == null) {
            System.out.println("Аннотация @Cache не найдена на классе CacheDemo.");
            return;
        }

        String[] regions = annotation.value();
        if (regions.length == 0) {
            System.out.println("Список кешируемых областей пуст.");
        } else {
            System.out.println("Кешируемые области: " + Arrays.toString(regions));
        }
    }
}
```

# Задание 2. Тестирование

## Задача 2

### Текст задачи

Создайте тест, используя фреймворк JUnit, который проверяет корректность вызова методов, отмеченных аннотацией @Invoke.

- Использовать Reflection API для поиска методов с аннотацией.
- Убедиться, что метод действительно выполняется без исключений.
- Проверить, что возвращаемое значение или побочный эффект соответствует ожиданиям (например, устанавливает флаг или изменяет состояние объекта).
- Тест должен использовать аннотацию @BeforeEach для подготовки тестируемого экземпляра класса.

### Алгоритм решения

**InvokeTest.java**

```java
package test;

import annotations.Invoke;
import entities.InvokeDemo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.Task1Service;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InvokeTest {

    private InvokeDemo demo;
    private Task1Service service;

    @BeforeEach
    void setUp() {
        demo = new InvokeDemo();
        service = new Task1Service();
    }

    @Test
    void invokesAnnotatedMethodsWithoutException() {
        List<Object> results = service.invokeAnnotatedMethods(demo);
        assertFalse(results.isEmpty(), "Должен быть хотя бы один вызванный метод");
        assertTrue(demo.wasInvoked(), "Флаг вызова должен быть установлен");
        assertEquals("Hello from @Invoke method", results.get(0));
    }
}
```

## Задача 6

### Текст задачи

Разработайте тест, используя фреймворк JUnit, проверяющий корректность обработки аннотации @Two, если её свойства заданы некорректно. Например, строковое свойство first пустое (""), а числовое second отрицательное.
 
- Создайте вспомогательный класс с аннотацией @Two(first = "", second = -1).
- В тесте реализуйте метод, который через Reflection считывает значения аннотации.
- Если одно из свойств нарушает ожидаемые условия (first – пустая строка, second < 0), то должен быть выброшен IllegalArgumentException.
- Используйте assertThrows() из JUnit для проверки выбрасываемого исключения.

### Алгоритм решения

**TwoAnnotationTest.java**

```java
package test;

import annotations.Two;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TwoAnnotationTest {

    @Two(first = "", second = -1)
    private static class InvalidTwoHolder {
    }

    @Test
    void throwsOnInvalidTwoProperties() {
        assertThrows(IllegalArgumentException.class, () -> {
            Two annotation = InvalidTwoHolder.class.getAnnotation(Two.class);
            validate(annotation);
        });
    }

    private void validate(Two annotation) {
        if (annotation == null) {
            throw new IllegalArgumentException("Аннотация @Two отсутствует");
        }
        if (annotation.first().isEmpty() || annotation.second() < 0) {
            throw new IllegalArgumentException("Некорректные значения @Two");
        }
    }
}
```
