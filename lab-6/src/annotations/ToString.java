package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Управляет тем, включать ли класс/поле в строковое представление.
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ToString {
    /**
     * @return режим включения: YES — добавить, NO — пропустить
     */
    Mode value() default Mode.YES;

    enum Mode { YES, NO }
}
