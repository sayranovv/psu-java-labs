package entities;

import annotations.Default;

/**
 * Образец класса с аннотацией @Default: хранит строку и демонстрирует доступ к типу по умолчанию.
 */
@Default(String.class)
public class DefaultDemo {
    /**
     * Демонстрационное значение, чтобы показать работу геттера и класса в целом.
     */
    private String value = "demo";

    /**
     * Возвращает сохраненную строку; используется в выводе сервиса.
     *
     * @return текстовое поле value
     */
    public String getValue() {
        return value;
    }
}
