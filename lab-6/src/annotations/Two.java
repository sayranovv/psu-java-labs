package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Хранит пару значений: строку и число, закрепленных за классом.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Two {
    /**
     * @return строковое свойство first
     */
    String first();
    /**
     * @return числовое свойство second
     */
    int second();
}
