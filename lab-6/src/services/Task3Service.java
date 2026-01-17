package services;

import annotations.ToString;
import entities.ToStringDemo;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

public class Task3Service {

    public void runTask3() {
        System.out.println("\n─── ЗАДАНИЕ 3: @ToString ───\n");
        ToStringDemo demo = new ToStringDemo();
        String representation = buildString(demo);
        System.out.println("Строковое представление объекта:");
        System.out.println(representation);
    }

    public String buildString(Object obj) {
        if (obj == null) {
            return "null";
        }

        Class<?> clazz = obj.getClass();
        if (!clazz.isAnnotationPresent(ToString.class)) {
            return obj.toString();
        }

        Map<String, Object> included = new LinkedHashMap<>();
        for (Field field : clazz.getDeclaredFields()) {
            ToString fieldAnno = field.getAnnotation(ToString.class);
            ToString.Mode mode = fieldAnno != null ? fieldAnno.value() : ToString.Mode.YES;
            if (mode == ToString.Mode.NO) {
                continue;
            }
            try {
                field.setAccessible(true);
                included.put(field.getName(), field.get(obj));
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Не удалось прочитать поле " + field.getName(), e);
            }
        }

        StringBuilder sb = new StringBuilder(clazz.getSimpleName()).append("{");
        boolean first = true;
        for (Map.Entry<String, Object> entry : included.entrySet()) {
            if (!first) {
                sb.append(", ");
            }
            sb.append(entry.getKey()).append("=").append(entry.getValue());
            first = false;
        }
        sb.append("}");
        return sb.toString();
    }
}
