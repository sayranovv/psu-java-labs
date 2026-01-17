package entities;

import annotations.Two;

/**
 * Класс-хранилище значений для аннотации @Two: строка и число.
 */
@Two(first = "sample", second = 7)
public class TwoDemo {
    /**
     * Содержит только аннотацию, данные читаются через reflection.
     */
}
