package entities;

import annotations.Invoke;

/**
 * Демонстрационный класс: содержит методы для проверки работы аннотации @Invoke.
 */
public class InvokeDemo {

    /**
     * Флаг, который показывает, что аннотированный метод действительно был вызван.
     */
    private boolean invoked;

    /**
     * Метод помечен @Invoke и должен вызываться обработчиком автоматически.
     * Здесь мы изменяем флаг и возвращаем строку, чтобы тесты могли проверить результат.
     *
     * @return строка-приветствие, подтверждающая вызов
     */
    @Invoke
    public String sayHello() {
        invoked = true;
        return "Hello from @Invoke method";
    }

    /**
     * Обычный метод без аннотации — нужен, чтобы показать, что он не будет вызван автоматически.
     *
     * @return текстовое значение, которое мы не ожидаем получать из обработчика
     */
    public String skipMe() {
        return "Not annotated";
    }

    /**
     * Возвращает состояние флага, чтобы убедиться, что аннотированный метод был вызван.
     *
     * @return true, если sayHello уже вызывался
     */
    public boolean wasInvoked() {
        return invoked;
    }
}
