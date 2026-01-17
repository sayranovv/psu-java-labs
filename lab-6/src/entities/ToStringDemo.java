package entities;

import annotations.ToString;

/**
 * Пример выбора полей для строкового представления при помощи аннотации @ToString.
 */
@ToString
public class ToStringDemo {

    /**
     * Это поле включается в строку, т.к. явно отмечено @ToString(YES).
     */
    @ToString
    private String title = "Included";

    /**
     * Это поле исключается из строки, т.к. отмечено @ToString(NO).
     */
    @ToString(ToString.Mode.NO)
    private String secret = "Hidden";

    /**
     * Поле без аннотации: по умолчанию режим YES, поэтому будет выведено.
     */
    private int number = 42;

    /**
     * @return значение title для возможных проверок
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return скрытое значение secret (не попадает в строку buildString)
     */
    public String getSecret() {
        return secret;
    }

    /**
     * @return числовое значение number
     */
    public int getNumber() {
        return number;
    }
}
