package utils;

public final class InputValidator {

    private InputValidator() {
    }

    public static boolean isNotEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input.trim());
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
