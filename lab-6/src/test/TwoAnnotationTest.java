package test;

import annotations.Two;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * JUnit тест проверяющий обработку некорректных значений аннотации @Two.
 */
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

