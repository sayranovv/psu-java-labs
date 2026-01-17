package utils;

/**
 * Утилитарный класс для валидации входных данных.
 */
public final class InputValidator {

    private InputValidator() {
    }

    /**
     * Проверяет, что строка не является null и не пуста после обрезки пробелов.
     */
    public static boolean isNotEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }

    /**
     * Верифицирует, что строка может быть преобразована в целое число.
     */
    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input.trim());
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
