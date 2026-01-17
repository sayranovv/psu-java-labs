package entities;

import annotations.Validate;

/**
 * Класс-маркер для демонстрации аннотации @Validate: хранит список валидаторов.
 */
@Validate({String.class, Integer.class})
public class ValidateDemo {
    /**
     * Тело класса пустое — важна только аннотация на типе.
     */
}
